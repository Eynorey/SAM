(function() {
    'use strict';

    angular
        .module('samApp')
        .controller('ProfileDetailController', ProfileDetailController);

    ProfileDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Profile', 'User', 'Skill'];

    function ProfileDetailController($scope, $rootScope, $stateParams, previousState, entity, Profile, User, Skill) {
        var vm = this;

        vm.profile = entity;
        vm.previousState = previousState.name;

        User.get({id: vm.profile.id}).$promise.then(function(user) {
            console.log(user);
        });

        var unsubscribe = $rootScope.$on('samApp:profileUpdate', function(event, result) {
            vm.profile = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
