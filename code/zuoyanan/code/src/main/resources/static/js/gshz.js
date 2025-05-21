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
        if (qssj === "") {
            qssj = "1999-01-01";
        }
        if (jzsj === "") {
            jzsj = "2030-12-31";
        }
        $ajax({
            type: 'post',
            url: '/gshz/select',
            data: {
                qssj :qssj,
                jzsj: jzsj,
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

            }
        })
    });

});

function setTable(data) {
    if ($('#gshzTable').html != '') {
        $('#gshzTable').bootstrapTable('load', data);
    }
    $('#gshzTable').bootstrapTable({
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
                field: 'm',
                title: '员工签名',
                align: 'center',
                sortable: true,
                width: 110,
            }, {
                field: 'l',
                title: '合计工时',
                align: 'center',
                sortable: true,
                width: 110,
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
