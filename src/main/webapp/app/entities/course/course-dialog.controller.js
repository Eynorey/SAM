(function () {
    'use strict';

    angular
        .module('samApp')
        .controller('CourseDialogController', CourseDialogController);

    CourseDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Course', 'Skill', 'User', 'Principal'];

    function CourseDialogController($timeout, $scope, $stateParams, $uibModalInstance, entity, Course, Skill, User, Principal) {
        var vm = this;

        vm.course = entity;
        vm.clear = clear;
        vm.datePickerOpenStatus = {};
        vm.openCalendar = openCalendar;
        vm.save = save;
        vm.skills = Skill.query();
        vm.users = User.query();

        $timeout(function () {
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear() {
            $uibModalInstance.dismiss('cancel');
        }

        function save() {
            vm.isSaving = true;
            vm.course.teachers = [vm.currentUser];
            if (vm.course.id !== null) {
                Course.update(vm.course, onSaveSuccess, onSaveError);
            } else {
                Course.save(vm.course, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess(result) {
            $scope.$emit('samApp:courseUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError() {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.start = false;
        vm.datePickerOpenStatus.end = false;

        function openCalendar(date) {
            vm.datePickerOpenStatus[date] = true;
        }

        /**
         * Store the "currentUser" in a separate variable, and not in the shared "account" variable.
         */
        var copyAccount = function (account) {
            return {
                id: account.id,
                login: account.login,
                firstName: account.firstName,
                lastName: account.lastName,
                email: account.email,
                activated: account.activated,
                langKey: account.langKey,
                imageUrl: account.imageUrl,
                resetKey: account.resetKey,
                resetDate: account.resetDate
            };
        };

        Principal.identity().then(function (account) {
            vm.currentUser = copyAccount(account);
        });
    }
})();
