'use strict';

/* Controllers */
var classifiedControllers = angular.module('classifiedControllers', ['ngMessages']);

classifiedControllers.controller("CategoryListCtrl", [ '$scope', 'Category',
		function($scope, Category) {
			console.info('CategoryListCtrl');
			$scope.categories = Category.query();

			// UI Column logic
			/*
			 * $scope.totalCol = 4; $scope.colCategories = [];
			 * 
			 * for(i =1; i <=totalCol; i++){ for(j = 1; j <= categories.length;
			 * j = j + totalCol){ colCategories[i][j] = categories[j]; } }
			 */
		} ]);

classifiedControllers.controller("SubCategoryListCtrl", [ '$scope',
		'$routeParams', 'SubCategory',
		function($scope, $routeParams, SubCategory) {
			console.info('SubCategoryListCtrl');
			console.info($routeParams);

			var categoryId = $routeParams.categoryId;
			var subCategoryId = $routeParams.subCategoryId;

			$scope.subCategory = SubCategory.get({
				subCategoryId : subCategoryId
			});

			// list type selector
			$scope.selected = 'list';
			$scope.listSelect = function(value) {
				$scope.selected = value;
			};

			$scope.isSet = function(value) {
				return $scope.selected === value;
			};

		} ]);

classifiedControllers.controller("ItemDetailCtrl", [ '$scope', '$routeParams',
		'Item', function($scope, $routeParams, Item) {
			console.info('ItemDetailCtrl');
			console.info($routeParams);

			var subcategoryId = $routeParams.subcategoryId;
			var itemId = $routeParams.itemId;

			// Get Item Detail - service Call
			$scope.item = Item.get({
				itemId : itemId
			});

			// Tab start
			$scope.tab = 1;
			$scope.setTab = function(value) {
				$scope.tab = value;
			};

			$scope.isSet = function(value) {
				return ($scope.tab === value);
			}
			// End Tab

			// Contact Form
			$scope.contact = {};
			$scope.submitForm = function() {
				// TODO call service
				console.info("contactForm" + console);

			};

		} ]);

classifiedControllers.controller("postAdCtrl", [ '$scope', 'Category', 'Item',
		function($scope, Category, Item) {
			console.info('postAdCtrl');

			$scope.item = new Item();
			$scope.categories = Category.query();
			$scope.isPosted = false;

			$scope.postAd = function() {
				console.info("creating new add");
				console.info('item' + $scope.item);

				if (postAdForm.$valid) {
					$scope.item.$save();
					// TODO ERROR HANdling
					$scope.isPosted = true;
				}
			};

		} ]);