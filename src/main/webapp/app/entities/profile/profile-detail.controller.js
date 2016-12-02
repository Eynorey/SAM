(function() {
    'use strict';

    angular
        .module('samApp')
        .controller('ProfileDetailController', ProfileDetailController);

    ProfileDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Profile', 'User', 'Course', 'Skill'];

    function ProfileDetailController($scope, $rootScope, $stateParams, previousState, entity, Profile, User, Course, Skill) {
        var vm = this;

        vm.profile = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('samApp:profileUpdate', function(event, result) {
            vm.profile = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
