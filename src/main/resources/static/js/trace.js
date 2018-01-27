$(function () {
    // var $nav = $('ul.nav'), $navbars = $nav.find('li'), $pages = $('div.page');
    var myChart = echarts.init($('#echarts-region')[0]);
    $('#dataModal').modal({
        show: false
    });

    function setModalMaxHeight(element) {
    	  this.$element     = $(element);  
    	  this.$content     = this.$element.find('.modal-content');
    	  var borderWidth   = this.$content.outerHeight() - this.$content.innerHeight();
    	  var dialogMargin  = $(window).width() < 768 ? 20 : 60;
    	  var contentHeight = $(window).height() - (dialogMargin + borderWidth);
    	  var headerHeight  = this.$element.find('.modal-header').outerHeight() || 0;
    	  var footerHeight  = this.$element.find('.modal-footer').outerHeight() || 0;
    	  var maxHeight     = contentHeight - (headerHeight + footerHeight);

    	  this.$content.css({
    	      'overflow': 'hidden'
    	  });
    	  
    	  this.$element
    	    .find('.modal-body').css({
    	      'max-height': maxHeight,
    	      'overflow-y': 'auto'
    	    });
    	}

    	$('.modal').on('show.bs.modal', function() {
    	  $(this).show(); 
    	  setModalMaxHeight(this);
    	});

    	$(window).resize(function() {
    	  if ($('.modal.in').length == 1) {
    	    setModalMaxHeight($('.modal.in'));
    	  }
    	});

    var imgPath = $('input#img-path').val();
    myChart.on('click', function (params) {
        if (!!params.data.type) {
            $('#dataModal img').attr('src', imgPath + params.data.type + '.jpg');
            $('#dataModal').modal('show');
        }
    });

    //var webcam = initSourceWebcam();
    let scanner = new Instascan.Scanner({ video: $('#webcam')[0] });
    var scanning = false;
    scanner.addListener('scan', function (content) {
        console.log(content);
        $('input#cap-code-input').val(content);
        $('#camModal').modal('hide');
    });

    $('#camModal').modal({ backdrop: 'static', show: false });
    $('button.close').on('click', function () {
        console.log('modal hide...');
        if (scanning) {
            closeScanner();
        }
    });

    function closeScanner() {
        scanner.stop().then(function() {
            scanning = false;
        }).catch(function(e) {
            console.error(e);
        });
    }

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
                    direction: 'inverse',
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

    $('button.scan').on('click', function () {
        if (scanning) {
            closeScanner();
            $('#camModal').modal('hide');
        } else {
            scanning = true;
            Instascan.Camera.getCameras().then(function (cameras) {
                if (cameras.length > 0) {
                    //$('#webcam').show();
                    scanner.start(cameras[0]);
                    $('#camModal').modal('show');
                } else {
                    console.error('No cameras found.');
                    scanning = false;
                }
            }).catch(function (e) {
                console.error(e);
                scanning = false;
            });
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
