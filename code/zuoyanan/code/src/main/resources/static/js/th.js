var idd;

function getList() {
   $("#F").val("")
    $ajax({
        type: 'post',
        url: '/th/getList',
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
    $('#select-btn').click(function () {

        var F = $('#F').val();
        $ajax({
            type: 'post',
            url: '/th/queryList',
            data: {
               F:F,
            }
        }, true, '', function (res) {
            if (res.code == 200) {
                setTable(res.data);
            }
        })
    });
    //刷新
    $("#refresh-btn").click(function () {
        getList();
    });
})
function setTable(data) {
    if ($('#thTable').html != '') {
        $('#thTable').bootstrapTable('load', data);
    }
    // 使用bootstrantable插件来加载数据到表格中
    $('#thTable').bootstrapTable({
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
        style:'table-layout:fixed;',
        columns: [
            {
                field: 'c',
                title: '退货客户',
                align: 'center',
                sortable: false,
                width: 120,
                height: 30
            }, {
                field: 'd',
                title: '退货电话',
                align: 'center',
                sortable: false,
                width: 120,
            }, {
                field: 'e',
                title: '退货日期',
                align: 'center',
                sortable: false,
                width: 120,
            }, {
                field: 'f',
                title: 'No',
                align: 'center',
                sortable: false,
                width: 120,
            },
            {
                field: 'g',
                title: '合同号',
                align: 'center',
                sortable: false,
                width: 120,
            },
            {
                field: 'h',
                title: '任务号',
                align: 'center',
                sortable: false,
                width: 120,
            },
            {
                field: 'i',
                title: '产品名称',
                align: 'center',
                sortable: false,
                width: 120,
            },
            {
                field: 'j',
                title: '图号',
                align: 'center',
                sortable: false,
                width: 120,
            },
            {
                field: 'k',
                title: '单位',
                align: 'center',
                sortable: false,
                width: 120,
            },
            {
                field: 'l',
                title: '数量',
                align: 'center',
                sortable: false,
                width: 120,
            },
            {
                field: 'm',
                title: '单价',
                align: 'center',
                sortable: false,
                width: 120,
            },
            {
                field: 'n',
                title: '金额',
                align: 'center',
                sortable: false,
                width: 120,
            },
            {
                field: 'o',
                title: '材质',
                align: 'center',
                sortable: false,
                width: 120,
            },
            {
                field: 'p',
                title: '重量',
                align: 'center',
                sortable: false,
                width: 120,
            },
            {
                field: 'q',
                title: '回厂日期',
                align: 'center',
                sortable: false,
                width: 120,
            },
            {
                field: 'r',
                title: '退货原因',
                align: 'center',
                sortable: false,
                width: 120,
            },
            {
                field: 's',
                title: '备注',
                align: 'center',
                sortable: false,
                width: 120,
            },
            {
                field: 't',
                title: '合计金额',
                align: 'center',
                sortable: false,
                width: 120,
            },{
                field: 'u',
                title: '地址',
                align: 'center',
                sortable: false,
                width: 120,
            },
            {
                field: 'v',
                title: '电话',
                align: 'center',
                sortable: false,
                width: 120,
            },

            {
                field: 'w',
                title: '客户签字',
                align: 'center',
                sortable: false,
                width: 120,
            },
            {
                field: 'x',
                title: '大写金额',
                align: 'center',
                sortable: false,
                width: 120,
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
