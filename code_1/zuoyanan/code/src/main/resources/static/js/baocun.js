var idd;
function getList() {
    $('#D').val("");
    $('#H').val("");
    $('#I').val("");
    $ajax({
        type: 'post',
        url: '/baocun/getList',
    }, false, '', function (res) {
        if (res.code == 200) {
            setTable(res.data);
            for (i=0;i<=res.data.id;i++){
                idd=i;
            }
        }
    })
}
$(function () {
    getList();
    //刷新
    $("#refresh-btn").click(function () {
        getList();
    });


    $('#select-btn').click(function () {
        var D = $('#D').val();
        var H = $('#H').val();
        var I = $('#I').val();
        $ajax({
            type: 'post',
            url: '/baocun/queryList',
            data: {
                D:D,
                H:H,
                I:I,
            }
        }, true, '', function (res) {
            if (res.code == 200) {
                setTable(res.data);
            }
        })
    });

    //点击修改按钮显示弹窗
    $('#update-btn').click(function () {
        let rows = getTableSelection('#baocunTable');
        if (rows.length > 1 || rows.length == 0) {
            swal('请选择一条数据修改!');
            return;
        }
        $('#update-modal').modal('show');
        setForm(rows[0].data, '#update-form');
        $('#update-C').val(rows[0].data.c);
        $('#update-D').val(rows[0].data.d);
        $('#update-E').val(rows[0].data.e);
        $('#update-F').val(rows[0].data.f);
        $('#update-G').val(rows[0].data.g);
        $('#update-H').val(rows[0].data.h);
        $('#update-I').val(rows[0].data.i);
        $('#update-J').val(rows[0].data.j);
        $('#update-K').val(rows[0].data.k);
        $('#update-L').val(rows[0].data.l);
        $('#update-M').val(rows[0].data.m);
        $('#update-N').val(rows[0].data.n);
        $('#update-O').val(rows[0].data.o);
        $('#update-P').val(rows[0].data.p);
        $('#update-Q').val(rows[0].data.q);
        $('#update-R').val(rows[0].data.r);
        $('#update-S').val(rows[0].data.s);
        $('#update-T').val(rows[0].data.t);
        $('#update-U').val(rows[0].data.u);
        $('#update-V').val(rows[0].data.v);

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
            let params = formToJson('#update-form');
            $ajax({
                type: 'post',
                url: '/baocun/update',
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
    });

    //点击删除按钮
    $('#delete-btn').click(function () {
        var msg = confirm("确认要删除吗？");
        if (msg) {
            let rows = getTableSelection("#baocunTable");
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
                url: '/baocun/delete',
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

})
function setTable(data) {
    if ($('#baocunTable').html != '') {
        $('#baocunTable').bootstrapTable('load', data);
    }
    // 使用bootstrantable插件来加载数据到表格中
    $('#baocunTable').bootstrapTable({
        data: data,
        sortStable: true,
        classes: 'tabled   table table-bordere  ',
        idField: 'id',
        pagination: true,
        pageSize: 50,//单页记录数
        locale: 'zh-CN',
        toolbar: '#table-toolbar',
        toolbarAlign: 'left',
        theadClasses: "thead-light12",//这里设置表头样式
        style:'table-layout:fixed;',
        columns: [
            {
                field: '',
                title: '序号',
                align: 'center',
                width: 60,
                formatter: function (value, row, index) {
                    return index + 1;
                }
            }, {
                field: 'c',
                title: '合同记录',
                align: 'center',
                sortable: true,
                width: 120,
            }, {
                field: 'd',
                title: '业务单位',
                align: 'center',
                sortable: true,
                width: 120,
            },
            {
                field: 'e',
                title: '数量',
                align: 'center',
                sortable: true,
                width: 80,
            },
            {
                field: 'f',
                title: '材质',
                align: 'center',
                sortable: true,
                width: 120,
            },
            {
                field: 'g',
                title: '零件名称',
                align: 'center',
                sortable: true,
                width: 120,
            },
            {
                field: 'h',
                title: '任务号',
                align: 'center',
                sortable: true,
                width: 80,
            },
            {
                field: 'i',
                title: '图号',
                align: 'center',
                sortable: true,
                width: 120,
            },
            {
                field: 'j',
                title: '工序名称',
                align: 'center',
                sortable: true,
                width: 120,
            },
            {
                field: 'k',
                title: '工序内容',
                align: 'center',
                sortable: true,
                width: 120,
            },
            {
                field: 'l',
                title: '合计工时',
                align: 'center',
                sortable: true,
                width: 120,
            },
            {
                field: 'm',
                title: '员工签名',
                align: 'center',
                sortable: true,
                width: 120,
            },
            {
                field: 'n',
                title: '完工时间',
                align: 'center',
                sortable: true,
                width: 120,
            },
            {
                field: 'o',
                title: '检验盖章',
                align: 'center',
                sortable: true,
                width: 120,
            },
            {
                field: 'p',
                title: '备注',
                align: 'center',
                sortable: true,
                width: 120,
            },
            {
                field: 'q',
                title: '工艺员',
                align: 'center',
                sortable: true,
                width: 120,
            },
            {
                field: 'r',
                title: '工艺员日期',
                align: 'center',
                sortable: true,
                width: 120,
            },
            {
                field: 's',
                title: '校对员',
                align: 'center',
                sortable: true,
                width: 120,
            },
            {
                field: 't',
                title: '校对员日期',
                align: 'center',
                sortable: true,
                width: 120,
            },
            {
                field: 'u',
                title: '批准员',
                align: 'center',
                sortable: true,
                width: 120,
            },
            {
                field: 'v',
                title: '批准员日期',
                align: 'center',
                sortable: true,
                width: 120,
            },  ],
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
