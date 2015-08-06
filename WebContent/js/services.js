'use strict';

/* Services */

var classifiedServices = angular.module('classifiedServices', [ 'ngResource' ]);

classifiedServices.factory('Category', [ '$resource', function($resource) {
	return $resource('data/:categoryId.json', {}, {
		query : {
			method : 'GET',
			params : {
				categoryId : 'category-list'
			},
			isArray : true
		}
	});
} ]);

classifiedServices.factory('SubCategory', [ '$resource', '$routeParams',
		function($resource, $routeParams) {
			console.info($routeParams);
			return $resource('data/:categoryId-:subcategoryId.json', {}, {
				query : {
					method : 'GET',
					params : {
						categoryId : $routeParams.categoryId,
						subcategoryId : $routeParams.subcategoryId
					},
					isArray : true
				}
			});
		} ]);

classifiedServices.factory('Item', [
		'$resource',
		'$routeParams',
		function($resource, $routeParams) {
			console.info($routeParams);
			return $resource('data/:categoryId-:subcategoryId-:itemId.json',
					{}, {
						get : {
							method : 'GET',
							params : {
								categoryId : $routeParams.categoryId,
								subcategoryId : $routeParams.subcategoryId,
								itemId : $routeParams.itemId
							},
							isArray : false
						}
					});
		} ]);
