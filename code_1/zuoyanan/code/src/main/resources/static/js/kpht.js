var idd;
var shuju;
function getList() {
    $('#gsm').val("");
    $ajax({
        type: 'post',
        url: '/kpht/getList',
    }, false, '', function (res) {

        if (res.code == 200) {
            idd=res.data.length;
            setTable(res.data);

            $("#kphtTable").colResizable({
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
        url: '/kpht/refresh',
    }, false, '', function (res) {
        if (res.code == 200) {
            setTable(res.data);
            $("#kphtTable").colResizable({
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

    //刷新
    $("#refresh-btn").click(function () {
        refresh();
    });

    //点击新增按钮显示弹窗
    $("#add-btn").click(function () {
        $('#add-modal').modal('show');
    });

    //新增弹窗里点击关闭按钮
    $('#add-close-btn').click(function () {
        $('#add-modal').modal('hide');
    });

    //新增弹窗里点击提交按钮
    $("#add-submit-btn").click(function () {
        let params = formToJson("#add-form");
        if (checkForm('#add-form')) {
            $ajax({
                type: 'post',
                url: '/kpht/add',
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

    //点击修改按钮显示弹窗
    $('#update-btn').click(function () {
        let rows = getTableSelection('#kphtTable');
        if (rows.length > 1 || rows.length == 0) {
            swal('请选择一条数据修改!');
            return;
        }
        $('#update-modal').modal('show');
        setForm(rows[0].data, '#update-form');
        $('#update-ywdw').val(rows[0].data.c);
        $('#update-hth').val(rows[0].data.d);
        $('#update-rwh').val(rows[0].data.e);
        $('#update-gygczt').val(rows[0].data.f);
        $('#update-gx').val(rows[0].data.g);
        $('#update-mc').val(rows[0].data.h);
        $('#update-th').val(rows[0].data.i);
        $('#update-dw').val(rows[0].data.j);
        $('#update-sl').val(rows[0].data.k);
        $('#update-cz').val(rows[0].data.l);
        $('#update-xhj').val(rows[0].data.m);
        $('#update-zl').val(rows[0].data.n);
        $('#update-gj').val(rows[0].data.o);
        $('#update-djgy').val(rows[0].data.p);
        $('#update-hjje').val(rows[0].data.q);
        $('#update-xgs').val(rows[0].data.r);
        $('#update-xdj').val(rows[0].data.s);
        $('#update-cgs').val(rows[0].data.t);
        $('#update-cdj').val(rows[0].data.u);
        $('#update-qgs').val(rows[0].data.v);
        $('#update-qdj').val(rows[0].data.w);
        $('#update-zjwwgs').val(rows[0].data.x);
        $('#update-zjwwdj').val(rows[0].data.y);
        $('#update-wwgs').val(rows[0].data.z);
        $('#update-wwdj').val(rows[0].data.aa);
        $('#update-tgs').val(rows[0].data.ab);
        $('#update-tdj').val(rows[0].data.ac);
        $('#update-ggs').val(rows[0].data.ac);
        $('#update-gdj').val(rows[0].data.ae);
        $('#update-mgs').val(rows[0].data.af);
        $('#update-mdj').val(rows[0].data.ag);
        $('#update-skxgs').val(rows[0].data.ah);
        $('#update-skxdj').val(rows[0].data.ai);
        $('#update-lc').val(rows[0].data.aj);
        $('#update-lcdj').val(rows[0].data.ak);
        $('#update-dhh').val(rows[0].data.al);
        $('#update-dhhdj').val(rows[0].data.am);
        $('#update-zzs').val(rows[0].data.an);
        $('#update-zzsdj').val(rows[0].data.ao);
        $('#update-xl').val(rows[0].data.ap);
        $('#update-skz').val(rows[0].data.aq);
        $('#update-hcrq').val(rows[0].data.ar);
        $('#update-ccrq').val(rows[0].data.as);
        $('#update-ddyqjh').val(rows[0].data.at);
        $('#update-x').val(rows[0].data.hetongZhuangtai);
        $('#update-c').val(rows[0].data.au);
        $('#update-djy').val(rows[0].data.av);
        $('#update-bz').val(rows[0].data.aw);

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
                    url: '/kpht/update',
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
                    let rows = getTableSelection("#kphtTable");
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
                        url: '/kpht/delete',
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
    //设置开票
    $('#szkp-btn').click(function () {
        var msg = confirm("确认要将选中数据设置已开票吗？");
        if (msg) {
            let rows = getTableSelection("#kphtTable");
            if (rows.length == 0) {
                swal('请选择要开票的数据！');
                return;
            }else if(rows.length>1){
                swal('请选择一条要开票的数据')
                return;
            }
            let id=rows[0].data.id;
            $ajax({
                type: 'post',
                url: '/kpht/szkp',
                data: JSON.stringify({
                    id:id
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
    })

});



function setTable(data) {
    if ($('#kphtTable').html != '') {
        $('#kphtTable').bootstrapTable('load', data);
    }
    $('#kphtTable').bootstrapTable({
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
                title: '业务单位',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'd',
                title: '合同号',
                align: 'center',
                sortable: true,
                width: 150,
            }, {
                field: 'e',
                title: '任务号',
                align: 'center',
                sortable: true,
                width: 110,
            }, {
                field: 'f',
                title: '对账状态',
                align: 'center',
                sortable: true,
                width: 110,
            }, {
                field: 'g',
                title: '工序',
                align: 'center',
                sortable: true,
                width: 110,
            }, {
                field: 'h',
                title: '名称',
                align: 'center',
                sortable: true,
                width: 150,
            }, {
                field: 'i',
                title: '图号',
                align: 'center',
                sortable: true,
                width: 100,
            }, {
                field: 'j',
                title: '单位',
                align: 'center',
                sortable: true,
                width: 100,
            }, {
                field: 'k',
                title: '数量',
                align: 'center',
                sortable: true,
                width: 100,
            }, {
                field: 'l',
                title: '材质',
                align: 'center',
                sortable: true,
                width: 100,
            }, {
                field: 'm',
                title: '序合计',
                align: 'center',
                sortable: true,
                width: 100,
            }, {
                field: 'n',
                title: '重量',
                align: 'center',
                sortable: true,
                width: 100,
            }, {
                field: 'o',
                title: '工件',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'p',
                title: '单价元',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'q',
                title: '合计金额',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'r',
                title: '铣工时/40',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 's',
                title: '铣单价/40',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 't',
                title: '车工时/40',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'u',
                title: '车单价/34',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'v',
                title: '钳工时/40',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'w',
                title: '钳单价',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'x',
                title: '整件外委工时/57.6',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'y',
                title: '整件外委单价',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'z',
                title: '外委工时/48',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'aa',
                title: '外委单价',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'ab',
                title: '镗工时/73',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'ac',
                title: '镗单价',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'ad',
                title: '割工时/24',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'ae',
                title: '割单价',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'af',
                title: '磨工时/42',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'ag',
                title: '磨单价',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'ah',
                title: '数控铣工时/69',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'ai',
                title: '数控铣单价',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'aj',
                title: '立车/71',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'ak',
                title: '立车单价',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'al',
                title: '电火花/42',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'am',
                title: '电火花单价',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'an',
                title: '中走丝/38',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'ao',
                title: '中走丝单价',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'ap',
                title: '下料',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'aq',
                title: '深孔钻',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'ar',
                title: '回厂日期',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'ass',
                title: '出厂日期',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'at',
                title: '订单要求交货',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'hetongZhuangtai',
                title: '铣',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'au',
                title: '车',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'av',
                title: '登记员',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'aw',
                title: '备注',
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