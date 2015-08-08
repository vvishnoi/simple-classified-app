'use strict';

// closure ct:categoryId sct:subcategoryId it : itemId, img:imageId
var classifiedApp = angular.module('classifiedApp', [ 'ngRoute',
		'classifiedControllers', 'classifiedServices' ]);

classifiedApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'fragments/category-list.html',
		controller : 'CategoryListCtrl'
	}).when('/:categoryName/:subCategoryName/ct/:categoryId/sct/:subCategoryId', {
		templateUrl : 'fragments/subcategory-list.html',
		controller : 'SubCategoryListCtrl'
	}).when('/:subCategoryName/:itemName/sct/:subcategoryId/it/:itemId', {
		templateUrl : 'fragments/item-details.html',
		controller : 'ItemDetailCtrl'
	}).when('/postad', {
		templateUrl : 'fragments/post-ad.html',
		controller : 'postAdCtrl'
	}).otherwise({
		redirectTo : '/'
	});
} ]);
