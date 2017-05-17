(function() {
    'use strict';

    angular
        .module('samApp')
        .controller('CourseDetailController', CourseDetailController);

    CourseDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Course', 'Skill', 'User'];

    function CourseDetailController($scope, $rootScope, $stateParams, previousState, entity, Course, Skill, User) {
        var vm = this;

        vm.course = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('samApp:courseUpdate', function(event, result) {
            vm.course = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
