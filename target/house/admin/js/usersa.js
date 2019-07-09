$(function () {
    // 展示数据列表
    $('#showUsers').datagrid({
        url: 'getAdminUsers',
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

// 弹出窗口
function openDialog(id, title) {
    $('#' + id).dialog({
        title: title,
        width: 400,
        height: 200,
        modal: true
    });
}


//关闭窗口
function closeDialog(id) {
    $("#" + id).dialog('close');
}

// 添加操作
function addSaveUser() {
    $('#addSubmit').form('submit', {
        url: 'addUser',
        success: function (data) {
            data = $.parseJSON(data);
            if (data.result) {
                $.messager.show({
                    title: '系统提示',
                    msg: '添加成功!',
                    timeout: 1500
                });
                closeDialog('addDialog');
                $('#showUsers').datagrid('reload');
            } else {
                $.messager.alert('系统提示！', '添加失败!');
            }
        }
    });
}

// 修改按钮
function updateButton() {
    var selectrows = $("#showUsers").datagrid('getSelections');
    if (selectrows.length != 1) {
        $.messager.alert('操作提示', '请选择且只能选择一行!');
        return;
    }
    $("#updateSubmit").form('load', selectrows[0]);
    $("#upassword").val(null);

    openDialog('updateDialog', '修改用户');
}

//修改操作
function updateSaveUser() {
    $('#updateSubmit').form('submit', {
        url: 'updateUser',
        success: function (data) {
            data = $.parseJSON(data);
            if (data.result) {
                $.messager.show({
                    title: '系统提示',
                    msg: '修改成功!',
                    timeout: 1500
                });
                closeDialog('updateDialog');
                $('#showUsers').datagrid('reload');
            } else {
                $.messager.alert('系统提示！', '修改失败!');
            }
        }
    });
}

// 删除按钮--复选
function deleteUsers() {
    var selectRows = $("#showUsers").datagrid('getSelections');
    if (selectRows.length == 0) {
        $.messager.alert('系统提示', '请选择您要删除的数据！');
        return;
    }
    var ids = new Array(selectRows.length);
    for (var i in selectRows) {
        ids.push(selectRows[i].id)
        //ids[i] = selectRows[i].id;
    }
    $.messager.confirm('系统提示', '是否删除' + selectRows.length + '条数据?', function (r) {
        if (r) {
            $.post('deleteUsers', {'ids': ids.join()}, function (data) {
                if (data.result) {
                    $('#showUsers').datagrid('reload');
                    $.messager.show({
                        title: '系统提示',
                        msg: '删除成功!',
                        timeout: 1500
                    });
                } else {
                    $.messager.alert('系统提示', '删除失败!');
                }
            }, 'json');
        }
    });
}

function searchUser() {
    var u_name = $("#name").val();
    var u_tel = $("#telephone").val();
    $('#showUsers').datagrid('load', {"name": u_name, "telephone": u_tel});
}