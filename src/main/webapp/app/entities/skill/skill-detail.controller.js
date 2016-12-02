(function() {
    'use strict';

    angular
        .module('samApp')
        .controller('SkillDetailController', SkillDetailController);

    SkillDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Skill'];

    function SkillDetailController($scope, $rootScope, $stateParams, previousState, entity, Skill) {
        var vm = this;

        vm.skill = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('samApp:skillUpdate', function(event, result) {
            vm.skill = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
