(function() {
    'use strict';

    angular
        .module('samApp')
        .controller('SkillDeleteController',SkillDeleteController);

    SkillDeleteController.$inject = ['$uibModalInstance', 'entity', 'Skill'];

    function SkillDeleteController($uibModalInstance, entity, Skill) {
        var vm = this;

        vm.skill = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;
        
        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            Skill.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
