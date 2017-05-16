(function() {
    'use strict';

    angular
        .module('samApp')
        .controller('SettingsController', SettingsController);

    SettingsController.$inject = ['Principal', 'Auth'];

    function SettingsController (Principal, Auth) {
        var vm = this;

        vm.error = null;
        vm.save = save;
        vm.settingsAccount = null;
        vm.settingsProfile = null;
        vm.success = null;

        //Birthday date picker
        vm.datePickerOpenStatus = {};
        vm.openCalendar = openCalendar;

        /**
         * Store the "settings account" in a separate variable, and not in the shared "account" variable.
         */
        var copyAccount = function (account) {
            return {
                activated: account.activated,
                email: account.email,
                firstName: account.firstName,
                langKey: account.langKey,
                lastName: account.lastName,
                login: account.login,
                degree: account.degree,
                semester: account.semester,
                faculty: account.faculty,
                university: account.university,
                birthday: new Date(account.birthday)
            };
        };


        Principal.identity().then(function(account) {
            vm.settingsAccount = copyAccount(account);
        });

        function save () {
            Auth.updateAccount(vm.settingsAccount).then(function() {
                vm.error = null;
                vm.success = 'OK';
                Principal.identity(true).then(function(account) {
                    vm.settingsAccount = copyAccount(account);
                });
            }).catch(function() {
                vm.success = null;
                vm.error = 'ERROR';
            });
        }

        vm.datePickerOpenStatus.birthday = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();
