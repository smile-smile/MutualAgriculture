/**
 * Created by Jiang on 2016/10/19.
 * 病害区
 */
function addDiseaseLayer(){

	   	map.clearOverlays();
	    var json;
	    var marker = new Array();
	    var url = "../pestZoneServlet?op=MapSearchAll";
		$.post(url,{},function getData(data){
			 alert(data);
			 json = JSON.parse(data);
			 for(var i=0;i<json.length;i++)
			 { 
				 //循环数据 json[i]//获取数据操作 
				 var content =  '<div style="margin:0;line-height:20px;padding:2px;">'+
								'<img src="img/weatherMarker/1.gif" alt="" style="float:right;zoom:1;overflow:hidden;width:100px;height:100px;margin-left:3px;"/>' +
								'病害程度：'+json[i].degree+
								'<br/>虫害类型：'+json[i].ptype+
								'<br/>病害类型：'+json[i].itype+
								'</div>';
				 addMarker(json[i].zone.address,i,content);
			 }
		});
		
		var myIcon = new BMap.Icon("img/logoMarker/disease.png", new BMap.Size(30,30),
			        {anchor:new BMap.Size(15,30),infoWindowAnchor: new BMap.Size(15, 0)} );
		
		 // 编写自定义函数,创建标注
	    function addMarker(address,i,content){
	       	
	    	// 创建地址解析器实例
			var myGeo = new BMap.Geocoder();
			myGeo.getPoint(address, function(point){
				if (point){		
						//创建检索信息窗口对象
						var searchInfoWindow = null;
						searchInfoWindow = new BMapLib.SearchInfoWindow(map, content, {
						title  : "病害",      //标题
						width  : 290,             //宽度
						height : 105,              //高度
						panel  : "panel",         //检索结果面板
						enableAutoPan : true,     //自动平移
						searchTypes   :[
						BMAPLIB_TAB_SEARCH,   //周边检索
						BMAPLIB_TAB_TO_HERE,  //到这里去
						//BMAPLIB_TAB_FROM_HERE //从这里出发
						]
						});
						marker[i]= new BMap.Marker(point,{icon:myIcon, enableDragging: false,
				            raiseOnDrag: true}); //创建marker对象
						marker[i].addEventListener("click", function(e){
							searchInfoWindow.open(marker[i]);
						})
						map.addOverlay(marker[i]); //在地图中添加marker
						marker[i].setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
					}
				else{
					alert("您选择地址没有解析到结果!");
				}
			}, "湖南省");
	    	
	    		    	
	    }
}
