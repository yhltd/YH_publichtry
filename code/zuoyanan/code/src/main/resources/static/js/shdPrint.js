var aa;
var idd = 0;
let count = 1;
var arr = {};
var n = 0;
var h = "";
let select = [];
let select_mc = [];
var y = 0;
var x = 0;
var z = 0;
var hjysje = 0;
var bz1;
var request;
var signBackRequest;
function columnUpd(id, column) {
    var this_value = $('#' + column + id).val();
    $ajax({
        type: 'post',
        url: '/shdp/update',
        data: {
            column: column,
            id: id,
            value: this_value,
        }
    }, false, '', function (res) {
        if (res.code == 200) {
            getList2();
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

function deleteq1() {
    var h = getQueryParam('biaoji');

    if (h == null || h == undefined) {
        $ajax({
            type: 'post',
            url: '/shdp/delete',
        })
    }

}

function getList() {

    $ajax({
        type: 'post',
        url: '/shdp/getList',
    }, false, '', function (res) {
        if (res.code == 200) {
            setTable(res.data);
            $("#shdpTable").colResizable({
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
function getList2() {

    $ajax({
        type: 'post',
        url: '/shdp/getList',
    }, false, '', function (res) {
        if (res.code == 200) {
            setTable(res.data);
            $("#shdpTable").colResizable({
                liveDrag: true,
                gripInnerHtml: "<div class='grip'></div>",
                draggingClass: "dragging",
                resizeMode: 'fit'
            });
        }
    })
}


function getList3() {
    $ajax({
        type: 'post',
        url: '/shdp/getList',
    }, false, '', function (res) {
        if (res.code == 200) {
            setTable(res.data);
            $("#shdpTable").colResizable({
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

// function shdp() {
//     window.location.reload();
// }

window.onload = deleteq1();
$(function () {
    deleteq1();
    getList2();
    //减一行

//加一行 add
    $('#add-btn1').click(function () {  // 假设按钮 ID 为 save-btn

        // document.getElementById("C").disabled=true;
        // document.getElementById("D").disabled=true;
        var C = document.getElementById("C").value;
        var D = document.getElementById("D").value;
        var E = document.getElementById("E").value;
        var F = document.getElementById("F").value;
        var G = document.getElementById("G").value;
        var H = document.getElementById("H").value;
        var I = document.getElementById("I").value;
        var Q = document.getElementById("Q").value;
        var R = document.getElementById("R").value;
        var S = document.getElementById("S").value;
        var T = document.getElementById("T").value;
        var U = document.getElementById("U").value;
        var V = document.getElementById("V").value;

        $ajax({
            type: 'post',
            url: '/shdp/add',
            data: {
                C: C,
                D: D,
                E: E,
                F: F,
                G: G,
                H: H,
                I: I,
                Q: Q,
                R: R,
                S: S,
                T: T,
                U: U,
                V: V
            }
        }, false, '', function (res) {

            getList3();

        })

    });

    //保存 add1
    $("#add-btn").click(function () {
        var requests = [];
        $.ajax({
            type: 'post',
            url: '/shdp/getList',
            async:false,
            success: function (res) {

                var z = res.data.length;
                for (var i = 0; i < z; i++) {
                    var q = (parseFloat($('#id1').val()) + i).toString();
                    var J = $('#J'+q).val();
                    //alert(J);
                   // console.log($('#j').length)
                    var K = $('#K'+q).val();
                    var L = $('#L'+q).val();
                    var M = $('#M'+q).val();
                    var N = $('#N'+q).val();
                    var O = $('#O'+q).val();
                    var P = $('#P'+q).val();
                    requests.push( $.ajax({
                            type: 'post',
                            url: '/shdp/update',
                            async: false,
                            data: {

                                J: J,
                                K: K,
                                L: L,
                                M: M,
                                N: N,
                                O: O,
                                P: P,
                                id:q,
                            },
                }))
        }},
        });
    })
    //暂存
    $("#add-btn2").click(function () {
        var requests = [];
        $.ajax({
            type: 'post',
            url: '/shdp/getList',
            async:false,
            success: function (res) {

                var z = res.data.length;
                for (var i = 0; i < z; i++) {
                    var C = document.getElementById("C").value;
                    var D = document.getElementById("D").value;
                    var E = document.getElementById("E").value;
                    var F = document.getElementById("F").value;
                    var G = document.getElementById("G").value;
                    var H = document.getElementById("H").value;
                    var I = document.getElementById("I").value;
                    var Q = document.getElementById("Q").value;
                    var R = document.getElementById("R").value;
                    var S = document.getElementById("S").value;
                    var T = document.getElementById("T").value;
                    var U = document.getElementById("U").value;
                    var V = document.getElementById("V").value;
                    var q = (parseFloat($('#id1').val()) + i).toString();
                    var J = $('#J'+q).val();
                    //alert(J);
                    // console.log($('#j').length)
                    var K = $('#K'+q).val();
                    var L = $('#L'+q).val();
                    var M = $('#M'+q).val();
                    var N = $('#N'+q).val();
                    var O = $('#O'+q).val();
                    var P = $('#P'+q).val();
                    requests.push( $.ajax({
                        type: 'post',
                        url: '/baocun/add',
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
                            //id:q,
                        },
                    }))
                }},
        });
    })
    $("#refresh-btn").click(function () {
        getList2();
    });

    //减一行 获取当前数据一共多少行，从最大id开始减
    $("#delete-btn1").click(function () {
        var requests = [];
        $.ajax({
            type: 'post',
            url: '/shdp/getList',
            async:false,
            success: function (res) {

                var z = res.data.length;
                for (var i = 0; i < z; i++) {
                    var q = (parseFloat($('#id1').val()) + i).toString();
                }
                requests.push($.ajax({
                    type: 'post',
                    url: '/shdp/delete1',
                    async: false,
                    data: {
                        id: q,
                    },
                }))
            },
        })
        getList3();  })


    // C:C,
    // D:D,
    // E:E,
    // F:F,
    // G:G,
    // H:H,
    // I:I,
    // Q:Q,
    // R:R,
    // S:S,
    // T:T,
    // U:U,
    // V:V,
    // var C = document.getElementById("C").value;
    // var D = document.getElementById("D").value;
    // var E = document.getElementById("E").value;
    // var F = document.getElementById("F").value;
    // var G = document.getElementById("G").value;
    // var H = document.getElementById("H").value;
    // var I = document.getElementById("I").value;
    // var Q = document.getElementById("Q").value;
    // var R = document.getElementById("R").value;
    // var S = document.getElementById("S").value;
    // var T = document.getElementById("T").value;
    // var U = document.getElementById("U").value;
    // var V = document.getElementById("V").value;
    //刷新

//     //点击查询按钮显示弹窗
//     $("#select-btn").click(function () {
//         $('#select-modal').modal('show');
//     });
//
//     //查询弹窗里点击关闭按钮
//     $('#select-close-btn').click(function () {
//         $('#select-modal').modal('hide');
//     });
// //查询按钮
//     $("#select-submit-btn").click(function () {
//         // 1. 获取表单数据
//         const params = formToJson("#select-form");
//         // 2. 表单验证
//         if (!checkForm('#select-form')) {
//             swal("警告", "请正确填写查询条件！", "warning");
//             return;
//         }
//         // 3. 发起 GET 请求（查询操作）
//         $.ajax({
//             type: 'GET',
//             url: '/shdp/queryList',  // 查询接口
//             data: params,         // 参数直接传递，自动转为 URL 查询字符串
//             dataType: 'json',
//             success: function (res) {
//                 if (res.code === 200) {
//                     // 4. 渲染查询结果到表格
//                     setTable(res.data);
//                     // renderTable(res.data);
//
//                     $('#select-modal').modal('hide'); // 关闭弹窗
//                     // $('#select-modal').reset();
//                 } else {
//                     swal("错误", res.msg || "查询失败", "error");
//                 }
//             },
//             error: function (xhr) {
//                 swal("错误", "请求失败: " + xhr.statusText, "error");
//             }
//         });
//         function renderTable(data) {
//             $('#show-shdPrint-table').bootstrapTable('load', data);
//         }
//         // 回调函数的参数可能不正确或不完整
//     })

    // $('#add-btn1').click(function () {
    //
    //
    //     var C="";
    //     var D="";
    //     var E="";
    //     var F="";
    //     var G="";
    //     var H="";
    //     var I="";
    //     var J="";
    //     var K="";
    //     var L="";
    //     var M="";
    //     var N="";
    //     var O="";
    //     var P="";
    //     var Q="";
    //     var R="";
    //     var S="";
    //     var T="";
    //     var U="";
    //     var V="";
    //
    //     $ajax({
    //
    //         type: 'post',
    //         url: '/shdp/add',
    //         data: {
    //             C: C,
    //             D: D,
    //             E: E,
    //             F: F,
    //             G: G,
    //             H: H,
    //             I: I,
    //             J: J,
    //             K: K,
    //             L: L,
    //             M: M,
    //             N: N,
    //             O: O,
    //             P: P,
    //             Q: Q,
    //             R: R,
    //             S: S,
    //             T: T,
    //             U: U,
    //             V: V
    //         }
    //     }, false, '', function (res) {
    //         getList();
    //
    //     })
    //
    // });

// //     //点击删除按钮
//     $('#delete-btn').click(function () {
//         var msg = confirm("确认要删除吗？");
//         if (msg) {
//             let rows = getTableSelection("#shdpTable");
//             if (rows.length == 0) {
//                 swal('请选择要删除的数据！');
//                 return;
//             }
//             let idList = [];
//             $.each(rows, function (index, row) {
//                 idList.push(row.data.id)
//             });
//             $ajax({
//                 type: 'post',
//                 url: '/shdp/delete',
//                 // 将要发送的数据转换成json格式（发送的数据为idlist集合）
//                 data: JSON.stringify({
//                     idList: idList
//                 }),
//                 // 服务器响应数据为json格式
//                 dataType: 'json',
//                 // 设置请求的内容类型为json格式，并且指定字符集为utf—8
//                 contentType: 'application/json;charset=utf-8'
//             }, false, '', function (res) {
//                 if (res.code == 200) {
//                     swal("", res.msg, "success");
//                     getList();
//                 } else {
//                     swal("", res.msg, "error");
//                 }
//             })
//         }
//     });
});


function setTable(data) {
    if ($('#shdpTable').html != '') {
        $('#shdpTable').bootstrapTable('load', data);
    }
    $('#shdpTable').bootstrapTable({
        data: data,
        sortStable: true,
        classes: 'table-hover text-nowrap table table-bordere',
        // table-hover text-nowrap table table-bordere
        idField: 'id',
        pagination: false,
        clickToSelect: true,
        locale: 'zh-CN',
        toolbar: '#table-toolbar',
        toolbarAlign: 'left',
        theadClasses: "thead-light13",//这里设置表头样式
        style: 'table-layout:fixed;',
        // height: document.body.clientHeight * 0.85,

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
                field: 'j',
                title: '工序名称',
                align: 'center',
                sortable: true,
                width: 120,
                formatter: function (value, row, index) {
                    if (value == null) {
                        value = '';
                    }
                    return "<textarea id='J" + row.id + "' oninput='javascript:columnUpd(" + row.id + "," + "\"J\"" + ")' placeholder='工序名称' type='text' class='form-control'  value='" + value + "'></textarea>"
                }
            },
            {
                field: 'k',
                title: '工序内容',
                align: 'center',
                sortable: true,
                width: 220,
                formatter: function (value, row, index) {
                    if (value == null) {
                        value = '';
                    }
                    return "<textarea id='K" + row.id + "' oninput='javascript:columnUpd(" + row.id + "," + "\"K\"" + ")' placeholder='工序内容' type='text' class='form-control'  value='" + value + "'></textarea>"
                }

            }, {
                field: 'l',
                title: '合计工时',
                align: 'center',
                sortable: true,
                width: 120,
                formatter: function (value, row, index) {
                    if (value == null) {
                        value = '';
                    }
                    return "<textarea id='L" + row.id + "' oninput='javascript:columnUpd(" + row.id + "," + "\"L\"" + ")' placeholder='合计工时' type='text' class='form-control'  value='" + value + "'></textarea>"
                }

            }, {
                field: 'm',
                title: '员工签名',
                align: 'center',
                sortable: true,
                width: 120,
                formatter: function (value, row, index) {
                    if (value == null) {
                        value = '';
                    }
                    return "<textarea id='M" + row.id + "' oninput='javascript:columnUpd(" + row.id + "," + "\"M\"" + ")' placeholder='员工签名' type='text' class='form-control'  value='" + value + "'></textarea>"
                }

            }, {
                field: 'n',
                title: '完工时间',
                align: 'center',
                sortable: true,
                width: 120,
                formatter: function (value, row, index) {
                    if (value == null) {
                        value = '';
                    }
                    return "<textarea id='N" + row.id + "' oninput='javascript:columnUpd(" + row.id + "," + "\"N\"" + ")' placeholder='完工时间' type='text' class='form-control'  value='" + value + "'></textarea>"
                }

            }, {
                field: 'o',
                title: '检验盖章',
                align: 'center',
                sortable: true,
                width: 120,
                formatter: function (value, row, index) {
                    if (value == null) {
                        value = '';
                    }
                    return "<textarea id='O" + row.id + "' oninput='javascript:columnUpd(" + row.id + "," + "\"O\"" + ")' placeholder='检验盖章' type='text' class='form-control'  value='" + value + "'></textarea>"
                }

            }, {
                field: 'p',
                title: '备注',
                align: 'center',
                sortable: true,
                width: 100,
                formatter: function (value, row, index) {
                    if (value == null) {
                        value = '';
                    }
                    return "<textarea id='P" + row.id + "' oninput='javascript:columnUpd(" + row.id + "," + "\"P\"" + ")' placeholder='备注' type='text' class='form-control'  value='" + value + "'></textarea>"
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

// function setTable(data) {
//     if ($('#show-shdPrint-table').html != '') {
//         $('#show-shdPrint-table').bootstrapTable('load', data);
//     }
//
//     $('#show-shdPrint-table').bootstrapTable({
//         data: data,
//         sortStable: true,
//         classes: 'table table-hover',
//         idField: 'id',
//         pagination: false,
//         search: true,
//         searchAlign: 'left',
//         clickToSelect: false,
//         locale: 'zh-CN',
//         singleSelect: true,
//         columns: [
//             {
//                 checkbox: true
//             },  {
//                 field: '',
//                 title: '序号',
//                 align: 'center',
//                 width: 60,
//                 formatter: function (value, row, index) {
//                     return index + 1;
//                 }
//             }, {
//                 field: 'j',
//                 title: '工序名称',
//                 align: 'center',
//                 sortable: true,
//                 width: 120,
//             }, {
//                 field: 'k',
//                 title: '工序内容',
//                 align: 'center',
//                 sortable: true,
//                 width: 220,
//             }, {
//                 field: 'l',
//                 title: '合计工时',
//                 align: 'center',
//                 sortable: true,
//                 width: 120,
//             }, {
//                 field: 'm',
//                 title: '员工签名',
//                 align: 'center',
//                 sortable: true,
//                 width: 120,
//             }, {
//                 field: 'n',
//                 title: '完工时间',
//                 align: 'center',
//                 sortable: true,
//                 width: 120,
//
//             }, {
//                 field: 'o',
//                 title: '检验盖章',
//                 align: 'center',
//                 sortable: true,
//                 width: 120,
//             }, {
//                 field: 'p',
//                 title: '备注',
//                 align: 'center',
//                 sortable: true,
//                 width: 100,
//             },
//             {
//                 field: 'id',
//                 title: 'id',
//                 align: 'center',
//                 sortable: true,
//                 width: 1,
//             }
//         ],
//
//         onClickRow: function (row, el) {
//             let isSelect = $(el).hasClass('selected')
//             if (isSelect) {
//                 $(el).removeClass('selected')
//             } else {
//                 $(el).addClass('selected')
//             }
//         }
//     })
// }



