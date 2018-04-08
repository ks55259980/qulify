$(function () {
    // var $nav = $('ul.nav'), $navbars = $nav.find('li'), $pages =
    // $('div.page');
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
        var width         = $(window).width() * 0.9; 
        
        this.$content.css({
            'overflow': 'hidden'
        });

        this.$element
        .find('.modal-body').css({
            'max-height': maxHeight,
            'overflow-y': 'auto'
        });
        
        this.$element
        .find('.modal-dialog').css({
            'width': width
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
    var lastNode;
    var lastCode;
    myChart.on('click', function (params) {
        console.log(params);
        if (params.data.type == 9999) {
            alert("无可用数据");
            return;
        }
        if (params.seriesName == 'Logistics') {
            return;
        }
        if (lastNode && lastCode && lastNode == params.name && lastCode == $('#cap-code-input').val()) {
            $('#dataModal').modal('show');
            return;
        } else {
            $('#dataModal .modal-body').empty();
            lastNode = params.name;
            lastCode = $('#cap-code-input').val();
        }
        if (params.data.type != null && params.data.value != null) {
            var type = params.data.type;
            var value = params.data.value;
            var originalCode = params.data.originalCode;
            $.get(
                    "/tracing/report", 
                    {"type": type, "code": value, "originalCode": originalCode},
                    function(response) {
                        if (response.code == 0 && response.data.length > 0) {
                            for (var i = 0; i < response.data.length; i++) {
                                getReportTable(response.data[i], i);
                            }
                        }
                    },
                    "json"
            );
            $('#dataModal').modal('show');
        }
    });

    function getReportTable(report, tableIndex){
        $('#dataModal .modal-body').append($('<h2>' + report.reportName + '</h2>'));
        $('#dataModal .modal-body').append($('<table id="table' + tableIndex + '"></table>'));
        var columns = [];
        for (var i = 0; i < report.columnId.length; i++) {
            columns.push({
                "field": report.columnId[i], 
                "title": report.columnName[i],
            });
        }
        $('#table' + tableIndex).bootstrapTable({
            columns: columns,
            data: report.records,
        });
    }

    // var webcam = initSourceWebcam();
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
                        left: '8%',
                        type: 'category',
                        boundaryGap: false,
                        data: data.from.processes,
                        top: '10%',
                        bottom: '40%',
                        right: '20%',
                        axisLabel: {
                            interval: 0
                        }
                    },
                    {
                        left: '8%',
                        type: 'category',
                        boundaryGap: false,
                        data: data.to.processes,
                        top: '70%',
                        bottom: '5%',
                        right: '30%',
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
                            left: '8%',
                            bottom: '40%',
                            right: '20%',
                            symbolSize: 7,
                            label: {
                                normal: {
                                    offset: [-75,-5],
                                    position: 'top',
                                    verticalAlign: 'bottom',
                                    align: 'left'
                                }
                            },
                            leaves: {
                                label: {
                                    normal: {
                                        offset: [0,0],
                                        position: 'right',
                                        verticalAlign: 'middle',
                                        align: 'left'
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

                            top: '70%',
                            left: '8%',
                            bottom: '5%',
                            right: '30%',
                            symbolSize: 7,
                            label: {
                                normal: {
                                    offset:[5,7],
                                    position: 'top',
                                    verticalAlign: 'bottom',
                                    align: 'left'
                                }
                            },
                            leaves: {
                                label: {
                                    normal: {
                                        offset:[0,0],
                                        position: 'right',
                                        verticalAlign: 'middle',
                                        align: 'left'
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
                    // $('#webcam').show();
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
