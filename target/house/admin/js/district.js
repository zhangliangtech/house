$(function () {
    // 展示数据列表
    $('#showDistricts').datagrid({
        url: 'getDistricts',
        title: '区域信息',
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
            {field: 'id', title: '区域编号', width: 100, align: 'center'},
            {field: 'name', title: '区域名称', width: 100, align: 'center'},
            {
                field: 'index', title: '操作', width: 100, align: 'center',
                formatter: function (value, row, index) {
                    return "<a href='javascript:deleteDistrict(" + row.id + ")'>删除</a>&nbsp;&nbsp;&nbsp;&nbsp;" +
                        "<a href='javascript:openStreetDialog(" + row.id + ")'>查看街道</a>";
                }
            }

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
function addSaveDistrict() {
    $('#addSubmit').form('submit', {
        url: 'addDistrict',
        success: function (data) {
            data = $.parseJSON(data);
            if (data.result) {
                $.messager.show({
                    title: '系统提示',
                    msg: '添加成功!',
                    timeout: 1500
                });
                closeDialog('addDialog');
                $('#showDistricts').datagrid('reload');
            } else {
                $.messager.alert('系统提示！', '添加失败!');
            }
        }
    });
}

// 修改按钮
function updateButton() {
    var selectrows = $("#showDistricts").datagrid('getSelections');
    if (selectrows.length != 1) {
        $.messager.alert('操作提示', '请选择且只能选择一行!');
        return;
    }
    $("#updateSubmit").form('load', selectrows[0]);
    openDialog('updateDialog', '修改区域');
}

//修改操作
function updateSaveDistrict() {
    $('#updateSubmit').form('submit', {
        url: 'updateDistrict',
        success: function (data) {
            data = $.parseJSON(data);
            if (data.result) {
                $.messager.show({
                    title: '系统提示',
                    msg: '修改成功!',
                    timeout: 1500
                });
                closeDialog('updateDialog');
                $('#showDistricts').datagrid('reload');
            } else {
                $.messager.alert('系统提示！', '修改失败!');
            }
        }
    });
}

// 删除按钮--复选
function deleteDistricts() {
    var selectRows = $("#showDistricts").datagrid('getSelections');
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
            $.post('deleteDistricts', {'ids': ids.join()}, function (data) {
                if (data.result) {
                    $('#showDistricts').datagrid('reload');
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

//删除单条
function deleteDistrict(id) {
    $.messager.confirm('系统提示', '是否删除该区域?', function (r) {
        if (r) {
            $.post('deleteDistrict', {'id': id}, function (data) {
                if (data.result) {
                    $('#showDistricts').datagrid('reload');
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

// 查看街道
var dis_id;
function openStreetDialog(id) {
    dis_id = id;
    // 展示数据列表
    $('#showStreets').datagrid({
        url: 'getStreetsById?id=' + id,
        pageNumber: 1,
        pageList: [10, 15, 20, 25, 30],
        pageSize: 15,
        pagination: true,
        striped: true,
        rownumbers: true,
        fit: true,
        fitColumns: true,
        checkOnSelect: false,
        toolbar: '#streetToolBar',
        columns: [[
            {field: 'cb', checkbox: 'true', width: 100, align: 'center'},
            {field: 'id', title: '街道编号', width: 100, align: 'center'},
            {field: 'name', title: '街道名称', width: 100, align: 'center'},
            {field: 'districtId', title: '区域ID', width: 100, align: 'center', hidden: true},
            {
                field: 'index', title: '操作', width: 100, align: 'center',
                formatter: function (value, row, index) {
                    return "<a href='javascript:deleteStreet(" + row.id + ")'>删除</a>";
                }
            }
        ]]
    });
    // 打开街道会话窗
    $("#StreetDialog").dialog(open).dialog('setTitle', '街道信息');


}

// 添加街道
function addStreets() {
    var street_name = $("#streetName").val();
    $.post('addStreet', {"districtId": dis_id, "name": street_name}, function (data) {
        if (data.result) {
            $.messager.show({
                title: '系统提示',
                msg: '添加成功!',
                timeout: 1500
            });
            $('#showStreets').datagrid('reload');
        } else {
            $.messager.alert('系统提示！', '添加失败!');
        }
    }, 'json');
}


// 删除街道按钮--复选
function deleteStreets() {
    var selectRows = $("#showStreets").datagrid('getSelections');
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
            $.post('deleteStreets', {'ids': ids.join()}, function (data) {
                if (data.result) {
                    $('#showStreets').datagrid('reload');
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
//删除单条街道
function deleteStreet(id) {
    $.messager.confirm('系统提示', '是否删除该街道?', function (r) {
        if (r) {
            $.post('deleteStreet', {'id': id}, function (data) {
                if (data.result) {
                    $('#showStreets').datagrid('reload');
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