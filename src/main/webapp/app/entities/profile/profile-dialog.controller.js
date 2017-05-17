(function() {
    'use strict';

    angular
        .module('samApp')
        .controller('ProfileDialogController', ProfileDialogController);

    ProfileDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', '$q', 'entity', 'Profile', 'User', 'Skill'];

    function ProfileDialogController ($timeout, $scope, $stateParams, $uibModalInstance, $q, entity, Profile, User, Skill) {
        var vm = this;

        vm.profile = entity;
        vm.clear = clear;
        vm.datePickerOpenStatus = {};
        vm.openCalendar = openCalendar;
        vm.save = save;
        vm.users = User.query();
        vm.skills = Skill.query();

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.profile.id !== null) {
                Profile.update(vm.profile, onSaveSuccess, onSaveError);
            } else {
                Profile.save(vm.profile, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('samApp:profileUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.birthday = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();
