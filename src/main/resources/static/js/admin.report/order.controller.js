/**
 * Created by StarRUC on 5/10/16.
 */

/**
 * Created by StarRUC on 5/10/16.
 */
var app = angular.module('smartYummy.app', []);


angular.module('smartYummy.app').controller('OrderReport.Controller', function ($scope, $log, $http, $timeout, $attrs, $window) {

    $scope.getReport = function(sortBy) {

        if (sortBy == null) {
            sortBy = 'order';
        }

        var startTime = $("#startTime").data('date');
        var endTime = $("#endTime").data('date');

        if ( startTime == null || endTime == null) {
            $window.alert('Please specify Start Time and End Time for query.');

        }
        else {
            $window.location.href='/admin/report/order?from=' + startTime + '&to=' + endTime + '&order=' + sortBy;
        }

    }

    $scope.getOrderDetail = function(id) {

        $window.location.href='/admin/report/detail?id=' + id;
    }

    function handleSuccess(res) {
        if (res.data.status=='success') {
            $window.alert('Order Confirmed.');
            $window.location.href='/';
        }
        else {
            //$window.alert('Sorry, the order can not be fullfilled in your required time. Our earliest available );
            $window.alert(res.data.error);
        }
    }

    function handleError(res) {
        $window.alert(res.data);
    }



});