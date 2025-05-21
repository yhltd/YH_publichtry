var idd;
var shuju;
function getList() {
    $('#gsm').val("");
    $ajax({
        type: 'post',
        url: '/thjl/getList',
    }, false, '', function (res) {

        if (res.code == 200) {
            idd=res.data.length;
            setTable(res.data);

            $("#thjlTable").colResizable({
                liveDrag: true,
                gripInnerHtml: "<div class='grip'></div>",
                draggingClass: "dragging",
                resizeMode: 'fit',
            });
        }
    })

}
function refresh(){
    $('#gsm').val("");
    $ajax({
        type: 'post',
        url: '/thjl/refresh',
    }, false, '', function (res) {
        if (res.code == 200) {
            setTable(res.data);
            $("#thjlTable").colResizable({
                liveDrag: true,
                gripInnerHtml: "<div class='grip'></div>",
                draggingClass: "dragging",
                resizeMode: 'fit'
            });
        }
    })
}
$(function () {
    getList();


    $ajax({
        type: 'post',
        url: '/user/getName',
    }, false, '', function (res) {
        var this_name = res.data
        document.getElementById("dlm").innerText = this_name;
    })

    $('#select-btn').click(function () {
        var qssj = $('#qssj').val();
        var jzsj = $('#jzsj').val();
        var hth = $('#hth').val();
        var rwh = $('#rwh').val();
        var th = $('#th').val();
        var thyy = $('#thyy').val();
        if (qssj === "") {
            qssj = "1999-01-01";
        }
        if (jzsj === "") {
            jzsj = "2030-12-31";
        }
        $ajax({
            type: 'post',
            url: '/thjl/cx',
            data: {
                qssj :qssj,
                jzsj: jzsj,
                hth :hth,
                rwh: rwh,
                th :th,
                thyy: thyy,
            }
        }, true, '', function (res) {
            if (res.code == 200) {
                setTable(res.data);
            }
        })
    });

    //刷新
    $("#refresh-btn").click(function () {
        refresh();
    });

    //点击新增按钮显示弹窗
    $("#cx-btn").click(function () {
        $('#add-modal').modal('show');
    });

    //新增弹窗里点击关闭按钮
    $('#add-close-btn').click(function () {
        $('#add-modal').modal('hide');
    });

    //点击删除按钮
    $('#delete-btn').click(function () {
        $ajax({
            type: 'post',
            url: '/user/getPower',
        }, false, '', function (res) {
            var quanxian = res.data
            if (quanxian=="管理员"){
                var msg = confirm("确认要删除吗？");
                if (msg) {
                    let rows = getTableSelection("#thjlTable");
                    if (rows.length == 0) {
                        swal('请选择要删除的数据！');
                        return;
                    }
                    let idList = [];
                    $.each(rows, function (index, row) {
                        idList.push(row.data.id)
                    });
                    $ajax({
                        type: 'post',
                        url: '/thjl/delete',
                        data: JSON.stringify({
                            idList: idList
                        }),
                        dataType: 'json',
                        contentType: 'application/json;charset=utf-8'
                    }, false, '', function (res) {
                        if (res.code == 200) {
                            swal("", res.msg, "success");
                            getList();
                        } else {
                            swal("", res.msg, "error");
                        }
                    })
                }
            }else{
                swal('无权限！');
            }
        })
    })
});

function setTable(data) {
    if ($('#thjlTable').html != '') {
        $('#thjlTable').bootstrapTable('load', data);
    }
    $('#thjlTable').bootstrapTable({
        data: data,
        sortStable: true,
        classes: 'table table-hover text-nowrap table table-bordered',
        idField: 'id',
        pagination: true,
        pageSize: 15,//单页记录数
        clickToSelect: true,
        locale: 'zh-CN',
        toolbar: '#table-toolbar',
        toolbarAlign: 'left',
        theadClasses: "thead-light",//这里设置表头样式
        style:'table-layout:fixed',
        columns: [
            {
                field: '',
                title: '序号',
                align: 'center',
                width: 50,
                formatter: function (value, row, index) {
                    return index + 1;
                }
            }, {
                field: 'c',
                title: '退货客户',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'd',
                title: '退货电话',
                align: 'center',
                sortable: true,
                width: 150,
            }, {
                field: 'e',
                title: '退货日期',
                align: 'center',
                sortable: true,
                width: 110,
            }, {
                field: 'w',
                title: '回厂日期',
                align: 'center',
                sortable: true,
                width: 110,
            }, {
                field: 'f',
                title: '退货单号',
                align: 'center',
                sortable: true,
                width: 110,
            }, {
                field: 'g',
                title: '合同号',
                align: 'center',
                sortable: true,
                width: 150,
            }, {
                field: 'h',
                title: '任务号',
                align: 'center',
                sortable: true,
                width: 100,
            }, {
                field: 'i',
                title: '产品名称',
                align: 'center',
                sortable: true,
                width: 100,
            }, {
                field: 'j',
                title: '图号',
                align: 'center',
                sortable: true,
                width: 100,
            }, {
                field: 'k',
                title: '单位',
                align: 'center',
                sortable: true,
                width: 100,
            }, {
                field: 'l',
                title: '数量',
                align: 'center',
                sortable: true,
                width: 100,
            }, {
                field: 'm',
                title: '单价',
                align: 'center',
                sortable: true,
                width: 100,
            }, {
                field: 'n',
                title: '金额',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'o',
                title: '材质',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'p',
                title: '重量',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'q',
                title: '退货原因',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'u',
                title: '备注',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'r',
                title: '地址',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 's',
                title: '客户签字',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 't',
                title: '电话',
                align: 'center',
                sortable: true,
                width: 130,
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