var app = angular.module("task", []);

app.controller("AppCtrl", function($scope, $http) {
    $scope.input;
    $scope.questions = [];
    $scope.nothingFound = false;

    $scope.getQuestions = function() {
        $scope.questions = [];
        $scope.nothingFound = false;
        if ($scope.input) {
            $http.get('http://localhost:8080/search/questions/' + $scope.input).success(function(data) {
                if (data && data.items.length > 0) {
                    $scope.questions = data.items;
                } else {
                    $scope.nothingFound = true;
                }
            });
        }
    };
});

app.directive('suchHref', ['$location', function () {
    return{
        restrict: 'A',
        link: function (scope, element, attr) {
            element.attr('style', 'cursor:pointer');
            element.on('click', function(){
                window.open(attr.suchHref);
            });
        }
    }
}]);

app.directive('myEnter', function () {
    return function (scope, element, attrs) {
        element.bind("keydown keypress", function (event) {
            if(event.which === 13) {
                scope.$apply(function (){
                    scope.$eval(attrs.myEnter);
                });

                event.preventDefault();
            }
        });
    };
});