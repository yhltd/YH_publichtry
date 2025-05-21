var idd = 0;
let select = [];
let count = 1;
var request;
var z = 0;
var y = 0;
var T=0;
var N=0;
var X=0;
var T_total = 0;
var aa;
function getHjje() {
    $("#X").val(menoyToUppercase(aa));
}
function columnUpd(id, column) {
    var this_value = $('#' + column + id).val();
    $ajax({
        type: 'post',
        url: '/thd/update',
        data: {
            column: column,
            id: id,
            value: this_value,
        }
    }, false, '', function (res) {
        if (res.code == 200) {
            getList();
        }
    })
}

function getQueryParam(paramName) {
    var queryString = window.location.search.substring(1);
    var params = queryString.split('&');
    for (var i = 0; i < params.length; i++) {
        var pair = params[i].split('=');
        if (pair[0] === paramName) {
            return pair[1];
        }
    }
    return null;
}

//清空
function deleteq1() {
    var h = getQueryParam('biaoji');

    if (h == null || h == undefined) {
        $ajax({
            type: 'post',
            url: '/thd/delete',
        })

    }

}
function shdp() {
    window.location.reload();
}

function getList() {

    $ajax({
        type: 'post',
        url: '/thd/getList',
    }, false, '', function (res) {
        if (res.code == 200) {
            setTable(res.data);
            $("#thdTable").colResizable({
                liveDrag: true,
                gripInnerHtml: "<div class='grip'></div>",
                draggingClass: "dragging",
                resizeMode: 'fit'
            });
            for (i = 0; i <= res.data.id; i++) {
                idd = i;
            }
        }
    })
}

window.onload = deleteq1();//  立即执行函数并将返回值赋给 window.onload
$(function () {
    deleteq1();
    getList();

//加一行
    $("#add-btn").click(function () {
        var C = document.getElementById("C").value;
        var D = document.getElementById("D").value;
        var E = document.getElementById("E").value;
        var F = document.getElementById("F").value;
        $ajax({
            type: 'post',
            url: '/thd/add',
            data: {
                C: C,
                D: D,
                E: E,
                F: F,
            }
        }, false, '', function (res) {
            getList();
        })
    });


    //减一行
    $("#delete-btn1").click(function () {
        var requests = [];
        $.ajax({
            type: 'post',
            url: '/thd/getList',
            async: false,
            success: function (res) {
                var z = res.data.length;
                for (var i = 0; i < z; i++) {
                    var q = (parseFloat($('#id1').val()) + i).toString();
                }
                requests.push($.ajax({
                    type: 'post',
                    url: '/thd/delete1',
                    async: false,
                    data: {
                        id: q,
                    },
                }))
            },
        })
        getList();

    })
    //生成新单
    $("#delete-btn").click(function () {
        const currentDate = new Date().toLocaleDateString();
        // 从localStorage中获取上次存储的日期和计数器值
        let lastDate = localStorage.getItem('lastDate');
        let count = parseInt(localStorage.getItem('count'), 10) || 0;
        // 检查当前日期是否与上次存储的日期相同
        if (currentDate !== lastDate) {
            // 如果不同，重置计数器
            count = 1;
        } else {
            // 如果相同，递增计数器
            count++;
        }
        localStorage.setItem('lastDate', currentDate);
        localStorage.setItem('count', count.toString().padStart(4, '0'));
        const date = new Date(currentDate);
        const year = date.getFullYear(); // 获取年份
        const month = String(date.getMonth() + 1).padStart(2, '0'); // 获取月份并补齐两位
        const day = String(date.getDate()).padStart(2, '0'); // 获取日期并补齐两位
        const dh = `${year}${month}${day}${count.toString().padStart(4, '0')}`;
        document.getElementById("F").value = dh;

        $('#C').val("");
        $('#D').val("");
        $('#E').val("");
        $('#T').val("");
        $('#U').val("");
        $('#V').val("");
        $('#W').val("");
        $('#X').val("");
        deleteq1();
        getList();

    })
//保存按钮
    $("#add-btn1").click(function () {
        var requests = [];
        $.ajax({
            type: 'post',
            url: '/thd/getList',
            async: false,
            success: function (res) {
                var z = res.data.length;
                var y = res.data.length;
                for (var i = 0; i < z; i++) {
                    var C = document.getElementById("C").value;
                    var D = document.getElementById("D").value;
                    var E = document.getElementById("E").value;
                    var F = document.getElementById("F").value;
                    var U = document.getElementById("U").value;
                    var V = document.getElementById("V").value;
                    var W = document.getElementById("W").value;

                    var q = (parseFloat($('#id1').val()) + i).toString();
                    var G = $('#G' + q).val();
                    var H = $('#H' + q).val();
                    var I = $('#I' + q).val();
                    var J = $('#J' + q).val();
                    var K = $('#K' + q).val();
                    var L = $('#L' + q).val();
                    var M = $('#M' + q).val();
                    var N = (parseFloat(L)*parseFloat(M)).toFixed(2);
                    var O = $('#O' + q).val();
                    var P = $('#P' + q).val();
                    var Q = $('#Q' + q).val();
                    var R = $('#R' + q).val();
                    var S = $('#S' + q).val();
                    var T = N;
                    aa=T;

                    getHjje();
                    var X = document.getElementById("X").value;

                    requests.push($.ajax({
                        type: 'post',
                        url: '/th/add',
                        async: false,
                        data: {
                            C: C,
                            D: D,
                            E: E,
                            F: F,
                            G: G,
                            H: H,
                            I: I,
                            J: J,
                            K: K,
                            L: L,
                            M: M,
                            N: N,
                            O: O,
                            P: P,
                            Q: Q,
                            R: R,
                            S: S,
                            T: T,
                            U: U,
                            V: V,
                            W: W,
                            X: X,
                        },
                    }))
                }
                $("#X").val("")
                var T = 0; // 初始化必须为数值类型
                for (var i = 0; i < y; i++) {
                    var q = (parseFloat($('#id1').val()) + i).toString();

                    // 处理空值和非数字输入
                    var L = parseFloat($('#L' + q).val()) || 0;
                    var M = parseFloat($('#M' + q).val()) || 0;

                    // 强制转换为数值
                    var N = Number((L * M).toFixed(2));

                    T += N; // 数值累加
                }
                $("#T").val(T);
                aa=T;
                getHjje();

            }

        })

    })

})


function menoyToUppercase(money) {

    var cnNums = new Array('零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'); //汉字的数字

    var cnIntRadice = new Array('', '拾', '佰', '仟'); //基本单位

    var cnIntUnits = new Array('', '万', '亿', '兆'); //对应整数部分扩展单位

    var cnDecUnits = new Array('角', '分', '毫', '厘'); //对应小数部分单位

    var cnInteger = '整'; //整数金额时后面跟的字符

    var cnIntLast = '元'; //整数完以后的单位

    //最大处理的数字

    var maxNum = 999999999999999.9999;

    var integerNum; //金额整数部分

    var decimalNum; //金额小数部分

    //输出的中文金额字符串

    var chineseStr = '';

    var parts; //分离金额后用的数组，预定义

    if (money == '') {
        return '';
    }

    money = parseFloat(money);

    if (money >= maxNum) {

    //超出最大处理数字

        return '超出最大处理数字';

    }

    if (money == 0) {

        chineseStr = cnNums[0] + cnIntLast + cnInteger;

        return chineseStr;

    }

    //四舍五入保留两位小数,转换为字符串

    money = Math.round(money * 100).toString();

    integerNum = money.substr(0, money.length - 2);

    decimalNum = money.substr(money.length - 2);

    //获取整型部分转换

    if (parseInt(integerNum, 10) > 0) {

        var zeroCount = 0;

        var IntLen = integerNum.length;

        for (var i = 0; i < IntLen; i++) {

            var n = integerNum.substr(i, 1);

            var p = IntLen - i - 1;

            var q = p / 4;

            var m = p % 4;

            if (n == '0') {

                zeroCount++;

            } else {

                if (zeroCount > 0) {

                    chineseStr += cnNums[0];

                }

                //归零

                zeroCount = 0;

                chineseStr += cnNums[parseInt(n)] + cnIntRadice[m];

            }

            if (m == 0 && zeroCount < 4) {

                chineseStr += cnIntUnits[q];

            }

        }

        chineseStr += cnIntLast;

    }

    //小数部分

    if (decimalNum != '') {

        var decLen = decimalNum.length;

        for (var i = 0; i < decLen; i++) {

            var n = decimalNum.substr(i, 1);

            if (n != '0') {

                chineseStr += cnNums[Number(n)] + cnDecUnits[i];

            }

        }

    }

    if (chineseStr == '') {

        chineseStr += cnNums[0] + cnIntLast + cnInteger;

    } else if (decimalNum == '' || /^0*$/.test(decimalNum)) {

        chineseStr += cnInteger;

    }

    return chineseStr;

}
function setTable(data) {
    if ($('#thdTable').html != '') {
        $('#thdTable').bootstrapTable('load', data);
    }
    $('#thdTable').bootstrapTable({
        data: data,
        sortStable: true,
        classes: 'table-hover text-nowrap table table-bordere',
        idField: 'id',
        pagination: false,
        clickToSelect: true,
        locale: 'zh-CN',
        toolbar: '#table-toolbar',
        toolbarAlign: 'left',
        theadClasses: "thead-light13",//这里设置表头样式
        style: 'table-layout:fixed;',
        columns: [
            {
                field: '',
                title: '序号',
                align: 'center',
                width: 60,
                formatter: function (value, row, index) {
                    var rows = row.length + 3;
                    return index + 1;
                }
            },
            {
                field: 'g',
                title: '合同号',
                align: 'center',
                sortable: true,
                width: 120,
                formatter: function (value, row, index) {
                    if (value == null) {
                        value = '';
                    }
                    return "<textarea id='G" + row.id + "' oninput='javascript:columnUpd(" + row.id + "," + "\"G\"" + ")' placeholder='合同号' type='text' class='form-control'  value='" + value + "'></textarea>"
                }
            },
            {
                field: 'h',
                title: '任务号',
                align: 'center',
                sortable: true,
                width: 120,
                formatter: function (value, row, index) {
                    if (value == null) {
                        value = '';
                    }
                    return "<textarea id='H" + row.id + "' oninput='javascript:columnUpd(" + row.id + "," + "\"H\"" + ")' placeholder='任务号' type='text' class='form-control'  value='" + value + "'></textarea>"
                }
            },
            {
                field: 'i',
                title: '产品名称',
                align: 'center',
                sortable: true,
                width: 120,
                formatter: function (value, row, index) {
                    if (value == null) {
                        value = '';
                    }
                    return "<textarea id='I" + row.id + "' oninput='javascript:columnUpd(" + row.id + "," + "\"I\"" + ")' placeholder='产品名称' type='text' class='form-control'  value='" + value + "'></textarea>"
                }
            },
            {
                field: 'j',
                title: '图号',
                align: 'center',
                sortable: true,
                width: 120,
                formatter: function (value, row, index) {
                    if (value == null) {
                        value = '';
                    }
                    return "<textarea id='J" + row.id + "' oninput='javascript:columnUpd(" + row.id + "," + "\"J\"" + ")' placeholder='图号' type='text' class='form-control'  value='" + value + "'></textarea>"
                }
            },
            {
                field: 'k',
                title: '单位',
                align: 'center',
                sortable: true,
                width: 60,
                formatter: function (value, row, index) {
                    if (value == null) {
                        value = '';
                    }
                    return "<textarea id='K" + row.id + "' oninput='javascript:columnUpd(" + row.id + "," + "\"K\"" + ")' placeholder='单位' type='text' class='form-control'  value='" + value + "'></textarea>"
                }
            }, {
                field: 'l',
                title: '数量',
                align: 'center',
                sortable: true,
                width: 80,
                formatter: function (value, row, index) {
                    if (value == null) {
                        value = '';
                    }
                    return "<textarea id='L" + row.id + "' oninput='javascript:columnUpd(" + row.id + "," + "\"L\"" + ")' placeholder='数量' type='text' class='form-control'  value='" + value + "'></textarea>"
                }
            }, {
                field: 'm',
                title: '单价',
                align: 'center',
                sortable: true,
                width: 80,
                formatter: function (value, row, index) {
                    if (value == null) {
                        value = '';
                    }
                    return "<textarea id='M" + row.id + "' oninput='javascript:columnUpd(" + row.id + "," + "\"M\"" + ")' placeholder='单价' type='text' class='form-control'  value='" + value + "'></textarea>"
                }
            }, {
                field: 'o',
                title: '材质',
                align: 'center',
                sortable: true,
                width: 120,
                formatter: function (value, row, index) {
                    if (value == null) {
                        value = '';
                    }
                    return "<textarea id='O" + row.id + "' oninput='javascript:columnUpd(" + row.id + "," + "\"O\"" + ")' placeholder='材质' type='text' class='form-control'  value='" + value + "'></textarea>"
                }
            }, {
                field: 'p',
                title: '重量',
                align: 'center',
                sortable: true,
                width: 80,
                formatter: function (value, row, index) {
                    if (value == null) {
                        value = '';
                    }
                    return "<textarea id='P" + row.id + "' oninput='javascript:columnUpd(" + row.id + "," + "\"P\"" + ")' placeholder='重量' type='text' class='form-control'  value='" + value + "'></textarea>"
                }
            },
            {
                field: 'q',
                title: '回厂日期',
                align: 'center',
                sortable: true,
                width: 100,
                formatter: function (value, row, index) {
                    if (value == null) {
                        value = '';
                    }
                    return "<textarea id='Q" + row.id + "' oninput='javascript:columnUpd(" + row.id + "," + "\"Q\"" + ")' placeholder='回厂日期' type='text' class='form-control'  value='" + value + "'></textarea>"
                }
            },
            {
                field: 'r',
                title: '退货原因',
                align: 'center',
                sortable: true,
                width: 100,
                formatter: function (value, row, index) {
                    if (value == null) {
                        value = '';
                    }
                    return "<textarea id='R" + row.id + "' oninput='javascript:columnUpd(" + row.id + "," + "\"R\"" + ")' placeholder='退货原因' type='text' class='form-control'  value='" + value + "'></textarea>"
                }
            },
            {
                field: 's',
                title: '备注',
                align: 'center',
                sortable: true,
                width: 100,
                formatter: function (value, row, index) {
                    if (value == null) {
                        value = '';
                    }
                    return "<textarea id='S" + row.id + "' oninput='javascript:columnUpd(" + row.id + "," + "\"S\"" + ")' placeholder='备注' type='text' class='form-control'  value='" + value + "'></textarea>"
                }
            },
            {
                field: 'id',
                title: 'id',
                align: 'center',
                sortable: true,
                width: 1,
                formatter: function (value, row, index) {
                    if (value == null) {
                        value = '';
                    }
                    var c = row.id
                    return "<input id='id1' name='id' value='" + c + "' oninput='javascript:columnUpd(" + row.id + "," + "\"id\"" + ")' placeholder='id' type='text' class='form-control'  value='" + value + "'>"
                }
            }
        ],

        onClickRow: function (row, el) {
            let isSelect = $(el).hasClass('selected')
            if (isSelect) {
                $(el).removeClass('selected')
            } else {
                $(el).addClass('selected')
            }
        }
    })
}