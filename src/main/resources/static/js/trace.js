$(function () {
    // var $nav = $('ul.nav'), $navbars = $nav.find('li'), $pages = $('div.page');
    var myChart = echarts.init($('#echarts-region')[0]);
    var webcam = initSourceWebcam();

    function paramString(form) {
        var param = '', $form = $(form);
        $form.find('input.request-param').each(function (e) {
            param += '&' + this.name + '=' + this.value;
        });
        console.log('parameters: ' + param);
        if (param.length === 0) {
            return '';
        }
        return '?' + param.slice(1);
    }

    function showChart(data) {
        if (data.type === 'sankey') {
            showSankeyView(data);
        } else if (data.type === 'tree') {
            showTreeView(data);
        }
    }

    function showTreeView(data) {
        myChart.setOption(option = {
            tooltip: {
                trigger: 'item',
                triggerOn: 'mousemove'
            },
            legend: {
                top: '2%',
                left: '3%',
                orient: 'vertical',
                data: [{
                    name: 'Production',
                    icon: 'rectangle'
                },
                {
                    name: 'Logistics',
                    icon: 'rectangle'
                }],
                borderColor: '#c23531'
            },
            singleAxis: [
                {
                    left: '7%',
                    type: 'category',
                    boundaryGap: false,
                    data: data.from.processes,
                    top: '10%',
                    bottom: '35%',
                    right: '20%',
                    axisLabel: {
                        interval: 0
                    }
                },
                {
                    left: '7%',
                    type: 'category',
                    boundaryGap: false,
                    data: data.to.processes,
                    top: '80%',
                    bottom: '10%',
                    right: '20%',
                    axisLabel: {
                        interval: 0
                    }
                }
            ],
            series: [
                {
                    type: 'tree',
                    name: 'Production',
                    data: [data.from.data],
                    top: '10%',
                    left: '7%',
                    bottom: '40%',
                    right: '20%',
                    symbolSize: 7,
                    label: {
                        normal: {
                            position: 'bottom',
                            horizontalAlign: 'middle',
                            align: 'middle'
                        }
                    },
                    leaves: {
                        label: {
                            normal: {
                                position: 'bottom',
                                horizontalAlign: 'middle',
                                align: 'middle'
                            }
                        }
                    },
                    expandAndCollapse: false,
                    animationDuration: 550,
                    animationDurationUpdate: 750
                },
                {
                    singleAxisIndex: 0,
                    coordinateSystem: 'singleAxis',
                    type: 'scatter',
                    data: [],
                    symbolSize: 0
                },
                {
                    type: 'tree',
                    name: 'Logistics',
                    data: [data.to.data],

                    top: '80%',
                    left: '7%',
                    bottom: '15%',
                    right: '20%',
                    symbolSize: 7,
                    label: {
                        normal: {
                            position: 'bottom',
                            horizontalAlign: 'middle',
                            align: 'middle'
                        }
                    },
                    leaves: {
                        label: {
                            normal: {
                                position: 'bottom',
                                horizontalAlign: 'middle',
                                align: 'middle'
                            }
                        }
                    },
                    expandAndCollapse: false,
                    animationDuration: 550,
                    animationDurationUpdate: 750
                },
                {
                    singleAxisIndex: 1,
                    coordinateSystem: 'singleAxis',
                    type: 'scatter',
                    data: [],
                    symbolSize: 0
                }
            ]
        });
    }

    function showSankeyView(data) {
        myChart.setOption(option = {
            title: {
                text: '追溯结果',
            },
            tooltip: {
                trigger: 'item',
                triggerOn: 'mousemove'
            },
            series: [
                {
                    type: 'sankey',
                    layout: 'none',
                    data: data.nodes,
                    links: data.links,
                    itemStyle: {
                        normal: {
                            borderWidth: 1,
                            borderColor: '#aaa'
                        }
                    },
                    lineStyle: {
                        normal: {
                            curveness: 0.5
                        }
                    },
                    label: {
                        normal: {
                            position: 'bottom',
                            horizontalAlign: 'middle',
                            align: 'middle'
                        }
                    },
                }
            ]
        });
    }

    // var setActiveTab = function (tab) {
    //     var $tab = $(tab);
    //     $navbars.each(function () {
    //         var $this = $(this);
    //         $this.removeClass('active');
    //         $($this.children().attr('href')).hide();
    //     });
    //     $tab.parent().addClass('active');
    //     $($tab.attr('href')).show();
    // };

    // setActiveTab($nav.find('a')[0]);

    var scanning = false;
    $('button.scan').on('click', function () {
        if (scanning) {
            $(webcam).remove();
            scanning = false;
        } else {
            $('.camera-div').append(webcam);
            scanning = true;
        }
    });

    $('button.tracing').on('click', function () {
        var form = this.form;
        var requestUri = '/' + this.name + paramString(form);
        console.log('button ' + this.name + ' clicked');
        myChart.clear();
        myChart.showLoading();
        fetch(requestUri, {
            credentials: 'same-origin',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json; charset=utf-8'
            },
        }).then(function (response) {
            if (response.ok) {
                return response.json();
            }
            throw new Error(response.status);
        }).then(function (data) {
            myChart.hideLoading();
            showChart(data);
        }).catch(function (e) {
            myChart.hideLoading();
            console.error('fetch error: ' + e.message);
        });
    });

});
