function fff() {
    baseOperation.ajax({
        type: "post",
        url: "/index/data",    //向springboot请求数据的url
        data: {},
        //datatype:json,
        success: function (data) {
            alert(data);
            //viewmodel.datalist = data;
        }
    });

}