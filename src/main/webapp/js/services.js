'use strict';

/* Services */

var classifiedServices = angular.module('classifiedServices', [ 'ngResource' ]);

classifiedServices.factory('Category', [ '$resource', function($resource) {
	return $resource('/category/:categoryId', {
		categoryId : '@id'
	}, {
		update : {
			method : 'PUT'
		}
	});
} ]);

classifiedServices.factory('SubCategory', [ '$resource', function($resource) {
	return $resource('/subcategory/:subCategoryId', null, {
		update : {
			method : "PUT"
		}
	});
} ]);

classifiedServices.factory('Item', [ '$resource', function($resource) {
	return $resource('item/:itemId', null, {
		update : {
			method : 'PUT'
		}
	});
} ]);
