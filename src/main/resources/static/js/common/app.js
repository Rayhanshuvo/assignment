var app = angular.module("InvoiceModule",[]);
app.controller("invoiceController", function($scope,$http, $compile){
	
	$scope.productList =[];
	$http({
  method: 'GET',
  url: '/products'
}).then(function successCallback(response) {
    $scope.productList = response.data;
  }, function errorCallback(response) {
    // called asynchronously if an error occurs
    // or server returns response with an error status.
  });
	
	console.log("invcon");
	$scope.customerName= "Rayhan Shuvo";
	$scope.qty= [];
	$scope.price = [];
	$scope.amount = [];
	$scope.lines =[];
	$scope.selectedProduct = [];
	$scope.salesInvoice={};
	$scope.salesInvoice.salesInvDetails=[];
	
	//$scope.products = ["Shoe","Skirts","Shirts","Pants"];
	$scope.addDiv = function(){
		
		$scope.lines.push($scope.lines.length);
		$scope.detail={};
		$scope.salesInvoice.salesInvDetails.push($scope.detail);
		
	}
	$scope.calculateAmount = function(line){
		if($scope.qty[line]){
		
			$scope.amount[line] = $scope.price[line] * $scope.qty[line];
			$scope.salesInvoice.salesInvDetails[line].quantity = $scope.qty[line];
			$scope.salesInvoice.salesInvDetails[line].amount = $scope.amount[line];
			
		}
		$scope.salesInvoice.totalAmount =0;
		for(var i =0;i<$scope.lines.length;i++){
			$scope.salesInvoice.totalAmount = $scope.salesInvoice.totalAmount + $scope.amount[i];
		}
	}
	
	$scope.getSelectedProduct = function(line){
	$scope.salesInvoice.salesInvDetails[line].productId = $scope.selectedProduct[line].productId;
	$scope.salesInvoice.salesInvDetails[line].productName = $scope.selectedProduct[line].productName;
	console.log($scope.selectedProduct[line]);
	console.log(line);
	$scope.price[line]=$scope.selectedProduct[line].sellingPrice;
	$scope.salesInvoice.salesInvDetails[line].unitPrice = $scope.price[line];
	}
	$scope.submit= function(){
			$http({
				  method: 'POST',
				  url: '/savesalesinv',
				  data : $scope.salesInvoice
				}).then(function successCallback(response) {
					

 $window.alert("Saved");

					
					
				    console.log("Saved");
				  }, function errorCallback(response) {
				    // called asynchronously if an error occurs
				    // or server returns response with an error status.
				  });
		
	}

})
