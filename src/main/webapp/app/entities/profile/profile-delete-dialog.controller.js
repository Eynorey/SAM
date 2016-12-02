(function() {
    'use strict';

    angular
        .module('samApp')
        .controller('ProfileDeleteController',ProfileDeleteController);

    ProfileDeleteController.$inject = ['$uibModalInstance', 'entity', 'Profile'];

    function ProfileDeleteController($uibModalInstance, entity, Profile) {
        var vm = this;

        vm.profile = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;
        
        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            Profile.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
