$(function () {

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
        var yuangong = $('#yuangong').val();
        if (qssj === "") {
            qssj = "1999-01-01";
        }
        if (jzsj === "") {
            jzsj = "2030-12-31";
        }
        $ajax({
            type: 'post',
            url: '/yggscx/select',
            data: {
                qssj :qssj,
                jzsj: jzsj,
                yuangong :yuangong,
            }
        }, true, '', function (res) {
            if (res.code == 200) {
                setTable(res.data);
            }
        })
    });


    $('#jisuan').click(function () {
        var qssj = $('#qssj').val();
        var jzsj = $('#jzsj').val();
        var yuangong = $('#yuangong').val();
        $ajax({
            type: 'post',
            url: '/yggscx/jisuan',
            data: {
                qssj :qssj,
                jzsj: jzsj,
                yuangong :yuangong,
            }
        }, true, '', function (res) {
            if (res.code == 200) {

                for (var i = 0; i < res.data.length; i++) {
                    var gs = res.data[i].L;
                    var hjgs=0;
                    var h1 = parseFloat(gs);
                    hjgs=hjgs+h1;
                }
                // $('#zgs1').innerText=zgs;
                $('#zgs1').text(zgs);
                // var gxsgz=$('#mxsgz1').val();
                var gxsgz = parseFloat($('#mxsgz1').val()) || 0;
                // $('#zgz1').innerText=gxsgz*zgs;
                $('#zgz1').text(gxsgz * zgs);
            }
        })
    });


});

function setTable(data) {
    if ($('#yggscxTable').html != '') {
        $('#yggscxTable').bootstrapTable('load', data);
    }
    $('#yggscxTable').bootstrapTable({
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
                field: 'j',
                title: '工序名称',
                align: 'center',
                sortable: true,
                width: 130,
            }, {
                field: 'k',
                title: '工序内容',
                align: 'center',
                sortable: true,
                width: 150,
            }, {
                field: 'l',
                title: '合计工时',
                align: 'center',
                sortable: true,
                width: 110,
            }, {
                field: 'm',
                title: '员工签名',
                align: 'center',
                sortable: true,
                width: 110,
            }, {
                field: 'n',
                title: '完工时间',
                align: 'center',
                sortable: true,
                width: 110,
            }, {
                field: 'o',
                title: '检验盖章',
                align: 'center',
                sortable: true,
                width: 150,
            }
            , {
                field: 'p',
                title: '备注',
                align: 'center',
                sortable: true,
                width: 150,
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
