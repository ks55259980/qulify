$(function() {
    var result = $('#result').text();
    var clipboard = new Clipboard('.clipboard-trigger', {
        text: function(trigger) {
            return result;
        }
    });
    clipboard.on('success', function(e) {
        console.info('Action:', e.action);
        console.info('Text:', e.text);
        console.info('Trigger:', e.trigger);
        alert('result copied to clipboard!');
    });
    clipboard.on('error', function(e) {
        console.error('Action:', e.action);
        console.error('Trigger:', e.trigger);
    });

    function paramString(form) {
        var param = '';
        var $form = $(form);
        $form.find('input.request-param').each(function(e) {
            param += '&' + this.name + '=' + this.value;
        });
        console.log('parameters: ' + param);
        if (param.length === 0) {
            return '';
        }
        return '?' + param.slice(1);
    }

    $('input.datetime').on('change', function() {
        var $this = $(this);
        var parent = $this.parents('.form-row')[0];
        var $timestamp = $(parent).find('input.timestamp');
        $timestamp.val(new Date($this.val()).getTime());
    });

    $('input.timestamp').on('change', function() {
        var $this = $(this);
        var parent = $this.parents('.form-row')[0];
        var $datetime = $(parent).find('input.datetime');
        var ts = parseInt($this.val());
        var localisotime = new Date(ts - new Date().getTimezoneOffset() * 60000);
        $datetime.val(localisotime.toISOString().slice(0, -8));
    });

    $('button.query').on('click', function() {
        var $btn = $(this);
        var form = $btn.parents('form')[0];
        console.log('button ' + $btn.attr('name') + ' clicked');
        var requestUri = '/' + $btn.attr('name') + paramString(form);
        if (confirm('confirm to send request: ' + requestUri)) {
            fetch(requestUri, {
                credentials: 'same-origin',
            })
            .then(function(response) {
                if (response.ok) {
                    return response.json();
                }
                throw new Error(response.status);
            })
            .then(function(json) {
                $('#result').text(JsonUti.convertToString(json));
                result = JSON.stringify(json);
            })
            .catch(function(e) {
                $('#result').text('fetch error: ' + e.message);
                result = e.message;
            });
        }
    });

    /* json formatter */
    var JsonUti = {
            // 定义换行符
            n: "\n",
            // 定义制表符
            t: "\t",
            // 转换String
            convertToString: function(obj) {
                return JsonUti.__writeObj(obj, 1);
            },
            // 写对象
            __writeObj: function(obj // 对象
                    , level // 层次（基数为1）
                    , isInArray) { // 此对象是否在一个集合内
                // 如果为空，直接输出null
                if (obj == null) {
                    return "null";
                }
                // 为普通类型，直接输出值
                if (obj.constructor == Number || obj.constructor == Date || obj.constructor == String || obj.constructor == Boolean) {
                    var v = obj.toString();
                    var tab = isInArray ? JsonUti.__repeatStr(JsonUti.t, level - 1) : "";
                    if (obj.constructor == String || obj.constructor == Date) {
                        // 时间格式化只是单纯输出字符串，而不是Date对象
                        return tab + ("\"" + v + "\"");
                    }
                    else if (obj.constructor == Boolean) {
                        return tab + v.toLowerCase();
                    }
                    else {
                        return tab + (v);
                    }
                }
                // 写Json对象，缓存字符串
                var currentObjStrings = [];
                // 遍历属性
                for (var name in obj) {
                    var temp = [];
                    // 格式化Tab
                    var paddingTab = JsonUti.__repeatStr(JsonUti.t, level);
                    temp.push(paddingTab);
                    // 写出属性名
                    temp.push("\"" + name + "\" : ");
                    var val = obj[name];
                    if (val == null) {
                        temp.push("null");
                    }
                    else {
                        var c = val.constructor;
                        if (c == Array) { // 如果为集合，循环内部对象
                            temp.push(JsonUti.n + paddingTab + "[" + JsonUti.n);
                            var levelUp = level + 2; // 层级+2
                            var tempArrValue = []; // 集合元素相关字符串缓存片段
                            for (var i = 0; i < val.length; i++) {
                                // 递归写对象
                                tempArrValue.push(JsonUti.__writeObj(val[i], levelUp, true));
                            }
                            temp.push(tempArrValue.join("," + JsonUti.n));
                            temp.push(JsonUti.n + paddingTab + "]");
                        }
                        else if (c == Function) {
                            temp.push("[Function]");
                        }
                        else {
                            // 递归写对象
                            temp.push(JsonUti.__writeObj(val, level + 1));
                        }
                    }
                    // 加入当前对象“属性”字符串
                    currentObjStrings.push(temp.join(""));
                }
                return (level > 1 && !isInArray ? JsonUti.n: "") // 如果Json对象是内部，就要换行格式化
                + JsonUti.__repeatStr(JsonUti.t, level - 1) + "{" + JsonUti.n // 加层次Tab格式化
                + currentObjStrings.join("," + JsonUti.n) // 串联所有属性值
                + JsonUti.n + JsonUti.__repeatStr(JsonUti.t, level - 1) + "}"; // 封闭对象
            },
            __isArray: function(obj) {
                if (obj) {
                    return obj.constructor == Array;
                }
                return false;
            },
            __repeatStr: function(str, times) {
                var newStr = [];
                if (times > 0) {
                    for (var i = 0; i < times; i++) {
                        newStr.push(str);
                    }
                }
                return newStr.join("");
            }
    };

});
