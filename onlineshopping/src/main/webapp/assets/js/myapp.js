$(function() {
	
	// Solving the active menu problem
switch (menu) {

case 'About Us':
	$('#about').addClass('active');
	break;
	
case 'All products':
	$('#listProducts').addClass('active');
	break;
	
case 'Contact Us':
	$('#contact').addClass('active');
	break;
		
	default:
    if (menu =="Home") break;
	$('#listProducts').addClass('active');
	$('#a_'+menu).addClass('active');
	

}


// code for jquery data table


var $table = $('#productListTable');
//execute the below code only where have this table

if($table.length) {
	//console.log('tttttttttttttt');
	
	
	var JsonUrl = '';
	if (window.categoryId ==''){
		
		JsonUrl = window.contextRoot +'/json/data/all/products';
		
	} else {
		
		JsonUrl = window.contextRoot +'/json/data/category/'+ window.categoryId +'/products';
	}
		
		
	$table.DataTable( {
		
		
	
		lengthMenu: [[3,5,10,-1],['3','5','10','All']],
		pageLength: 5,
		ajax: {
			url: JsonUrl,
			dataSrc: ''
			},
	    columns: [
	    	
	    	{
	    		data:'code',
	    		bSortable: false,
	    		mRender: function(data,type,row){
	    			
	    			return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>'
	    		}
	    	},
	    	{
	    		data:'name'
	    	},
	    	{
	    		data:'brand'
	    	},
	    	{
	    		data:'unitPrice',
	    		mRender: function(data,type,row){
	    			return data +' &#8364;'
	    		}	
	    	},
	    	{
	    		data:'quantity',
	    		mRender: function(data,type,row){
	    			if (data < 1 ) return '<span style = "color : red ">Out of Stock</span>';
	    			else return data ;
	    			
	    		}	
	    	},
	    	{
	    		data: 'id',
	    		bSortable: false,
	    		mRender: function(data,type,row){
	    			if (row.quantity < 1) {
	    				
	    				str='';
		    			str += '<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-eye-open" ></span></a>'
		    			str += ' '
		    			str += '<a href="javascript : void(0)" class="btn btn-success btn-sm disabled"><strike><span class="glyphicon glyphicon-shopping-cart" ></span></strike></a>'
		    			return str;
	    				
	    			}
	    			else {
	    			str='';
	    			str += '<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary btn-sm "><span class="glyphicon glyphicon-eye-open" ></span></a>'
	    			str += ' '
	    			str += '<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success btn-sm"><span class="glyphicon glyphicon-shopping-cart" ></span></a>'
	    			return str;}
	    		}
	    	}
	    	
	    ]
		
	} );
	
	
}



	
});