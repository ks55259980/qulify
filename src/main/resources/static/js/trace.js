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
    $('button.scan').on('click', function() {
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
        myChart.showLoading();
        fetch(requestUri, {
            credentials: 'same-origin',
        }).then(function (response) {
            if (response.ok) {
                return response.json();
            }
            throw new Error(response.status);
        }).then(function (data) {
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
                        }
                    }
                ]
            });
        }).catch(function (e) {
            console.error('fetch error: ' + e.message);
        }).finally(function() {
            myChart.hideLoading();
        });
    });

});
