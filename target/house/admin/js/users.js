$(function () {
    // 展示数据列表
    $('#showUsers').datagrid({
        url: 'getUsers',
        title: '用户信息',
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
            {field: 'cb', checkbox: 'true', width: 100, align: 'center'},
            {field: 'id', title: '编号', width: 100, align: 'center', hidden: true},
            {field: 'name', title: '用户名', width: 100, align: 'center'},
            {field: 'telephone', title: '联系方式', width: 100, align: 'center'}
        ]]
    });
});

function searchUser() {
    var u_name = $("#name").val();
    var u_tel = $("#telephone").val();
    $('#showUsers').datagrid('load', {"name": u_name, "telephone": u_tel});
}