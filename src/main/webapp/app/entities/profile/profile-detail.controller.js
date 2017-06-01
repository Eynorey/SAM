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
        vm.user = null;

        User.query().$promise.then(function(users) {
            for (var i = 0; i < users.length; i++) {
                var user = users[i];
                if(user.id === vm.profile.id) {
                    vm.user = user;
                }
            }
        });

        var unsubscribe = $rootScope.$on('samApp:profileUpdate', function(event, result) {
            vm.profile = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
