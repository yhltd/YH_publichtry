var idd;

function getList() {
    $('#C').val("");
    $('#D').val("");
    $('#E').val("");
    $ajax({
        type: 'post',
        url: '/peizhi/getList',
    }, false, '', function (res) {
        if (res.code == 200) {
            setTable(res.data);
            for (i = 0; i <= res.data.id; i++) {
                idd = i;
            }
        }
    })
}

$(function () {
    getList();
    //查
    $("#select-btn").click(function () {
        var C = $('#C').val();
        var D = $('#D').val();
        var E = $('#E').val();
        $ajax({
            type: 'post',
            url: '/peizhi/queryList',
            data: {
                C: C,
                D: D,
                E: E,
            }
        }, true, '', function (res) {
            if (res.code == 200) {
                setTable(res.data);
            }

        });
    })

    //刷新
    $("#refresh-btn").click(function () {
        getList();
    });

    //增
    //点击新增按钮显示弹窗
    $("#add-btn").click(function () {
        $('#add-modal').modal('show');
    });
//
//新增弹窗里点击关闭按钮
    $('#add-close-btn').click(function () {
        $('#add-modal').modal('hide');
    });
//
//     //新增弹窗里点击提交按钮
    $("#add-submit-btn").click(function () {
        let params = formToJson("#add-form");
        if (checkForm('#add-form')) {
            $ajax({
                type: 'post',
                url: '/peizhi/add',
                data: JSON.stringify({
                    addInfo: params
                }),
                dataType: 'json',
                contentType: 'application/json;charset=utf-8'
            }, false, '', function (res) {
                if (res.code == 200) {
                    swal("", res.msg, "success");
                    $('#add-form')[0].reset();
                    getList();
                    $('#add-close-btn').click();
                }
            })

        }
    });


    //删
    $('#delete-btn').click(function () {
        var msg = confirm("确认要删除吗？");
        if (msg) {
            let rows = getTableSelection("#peizhiTable");
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
                url: '/peizhi/delete',
                // 将要发送的数据转换成json格式（发送的数据为idlist集合）
                data: JSON.stringify({
                    idList: idList
                }),
                // 服务器响应数据为json格式
                dataType: 'json',
                // 设置请求的内容类型为json格式，并且指定字符集为utf—8
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
    });


    //改
    $('#update-btn').click(function () {
        let rows = getTableSelection('#peizhiTable');
        if (rows.length > 1 || rows.length == 0) {
            swal('请选择一条数据修改!');
            return;
        }
        $('#update-modal').modal('show');
        setForm(rows[0].data, '#update-form');
        $('#update-C').val(rows[0].data.c);
        $('#update-D').val(rows[0].data.d);
        $('#update-E').val(rows[0].data.e);

    });

    //修改弹窗点击关闭按钮
    $('#update-close-btn').click(function () {
        $('#update-form')[0].reset();
        $('#update-modal').modal('hide');
    });

    //修改弹窗里点击提交按钮
    $('#update-submit-btn').click(function () {
        var msg = confirm("确认要修改吗？");
        if (msg) {
            if (checkForm('#update-form')) {
                let params = formToJson('#update-form');
                $ajax({
                    type: 'post',
                    url: '/peizhi/update',
                    data: {
                        updateJson: JSON.stringify(params)
                    },
                    dataType: 'json',
                    contentType: 'application/json;charset=utf-8'
                }, false, '', function (res) {
                    if (res.code == 200) {
                        swal("", res.msg, "success");
                        $('#update-close-btn').click();
                        $('#update-modal').modal('hide');
                        getList();
                    } else {
                        swal("", res.msg, "error");
                    }
                })

            }
        }
    });





})

function setTable(data) {
    if ($('#peizhiTable').html != '') {
        $('#peizhiTable').bootstrapTable('load', data);
    }
    // 使用bootstrantable插件来加载数据到表格中
    $('#peizhiTable').bootstrapTable({
        data: data,
        sortStable: true,
        classes: 'tabled   table table-bordere  ',
        // table-hover text-nowrap table table-bordere
        idField: 'id',
        pagination: true,
        pageSize: 50,//单页记录数
        // clickToSelect: false,
        locale: 'zh-CN',
        toolbar: '#table-toolbar',
        toolbarAlign: 'left',
        theadClasses: "thead-light12",//这里设置表头样式
        style: 'table-layout:fixed;',
        columns: [
            {
                field: 'c',
                title: '工艺员',
                align: 'center',
                sortable: false,

                width: 50,
                height: 30
            }, {
                field: 'd',
                title: '校对员',
                align: 'center',
                sortable: false,
                width: 50,
            }, {
                field: 'e',
                title: '批准',
                align: 'center',
                sortable: false,
                width: 50,
            },
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
