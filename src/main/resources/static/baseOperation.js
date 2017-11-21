let baseOperation ={
    ajax:function(opt){
        let xhr = this.createXhrObject();
        xhr.onreadystatechange = function(){
        if(xhr.readyState!=4) return ;
            (xhr.status===200 ?
            opt.success(xhr.responseText,xhr.responseXML):
            opt.error(xhr.responseText,xhr.status));
        };
        xhr.open(opt.type,opt.url,true);
        if(opt.type!=='post')
            opt.data=null;
        else
            xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
        opt.data = this.parseQuery(opt.data);
        xhr.send(opt.data);
    },
    post:function(url,success,data){
        let popt = {
            url:url,
            type:'post',
            data:data,
            success:success,
            error:function(data){}
        };
        this.ajax(popt);
    },
    get:function(url,success){
        let gopt = {
            url:url,
            type:'get',
            success:success,
            error:function(){}
        };
        this.ajax(gopt);
    },
    createXhrObject:function(){
        let methods = [
            function(){ return new XMLHttpRequest();},
            function(){ return new ActiveXObject('Msxml2.XMLHTTP');},
            function(){ return new ActiveXObject('Microsoft.XMLHTTP');}
            ];
        for(let i=0;len=methods.length,i<len;i++){
            try{
                methods[i]();
            }catch(e){
                continue;
            }
            this.createXhrObject = methods[i];
                return methods[i]();
        }
        throw new Error('Could not create an XHR object.');
    },
    parseQuery:function(json){
        if(typeof json == 'object'){
            let str = '';
            for(var i in json){
                str += "&"+i+"="+encodeURIComponent(json[i]);
            }
        return str.length==0 ? str : str.substring(1);
        }else{
        return json;
        }
    }

}