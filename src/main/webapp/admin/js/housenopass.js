$(function () {
    // 展示数据列表
    $('#showHouses').datagrid({
        url: 'getHousesNoPass',
        title: '审核信息',
        pageNumber: 1,
        pageList: [10, 20, 30, 40, 50],
        pageSize: 20,
        pagination: true,
        striped: true,
        rownumbers: true,
        fit: true,
        fitColumns: true,
        checkOnSelect: false,
        toolbar: '#rudToolBar',
        columns: [[
            {field: 'id', title: '编号', width: 100, align: 'center', hidden: true},
            {field: 'userName', title: '用户名称', width: 100, align: 'center'},
            {field: 'typeName', title: '房屋类型', width: 100, align: 'center'},
            {field: 'title', title: '标题', width: 100, align: 'center'},
            {field: 'description', title: '描述', width: 150, align: 'center'},
            {
                field: 'price',
                title: '出租价',
                width: 100,
                align: 'center',
                formatter: function (value, row, index) {
                    return value + "元/月";
                }
            },
            {
                field: 'pubdate', title: '发布日期', width: 100, align: 'center',
                formatter: function (value, row, index) {
                    var date = new Date(value);
                    var year = date.getFullYear();
                    var month = date.getMonth() + 1;
                    var day = date.getDate();
                    return year + "年" + month + "月" + day + "日";
                }
            },
            {field: 'floorage', title: '面积', width: 100, align: 'center'},
            {field: 'contact', title: '联系人', width: 120, align: 'center'},
            {field: 'streetName', title: '街道编号', width: 100, align: 'center'},
            {
                field: 'ispass',
                title: '审核状态',
                width: 100,
                align: 'center',
                formatter: function (value, row, index) {
                    if (value == 1) {
                        return "通过";
                    } else {
                        return "未通过";
                    }
                }
            },
            {
                field: 'index', title: '审核操作', width: 100, align: 'center',
                formatter: function (value, row, index) {
                        return "<a href='javascript:passHouse(" + row.id + ")'>通过</a>";
                }
            }
        ]]
    });
});

//审核
function passHouse(id) {
    $.messager.confirm('系统提示', '是否审核通过', function (r) {
        if (r) {
            $.post('passHouse', {'id': id}, function (data) {
                if (data.result) {
                    $('#showHouses').datagrid('reload');
                    $.messager.show({
                        title: '系统提示',
                        msg: '操作成功!',
                        timeout: 1500
                    });
                } else {
                    $.messager.alert('系统提示', '操作失败!');
                }
            }, 'json');
        }
    });
}
