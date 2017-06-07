(function() {
    'use strict';

    angular
        .module('samApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('profile', {
            parent: 'entity',
            url: '/profile?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'SAM - Users'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/profile/profiles.html',
                    controller: 'ProfileController',
                    controllerAs: 'vm'
                }
            },
            params: {
                page: {
                    value: '1',
                    squash: true
                },
                sort: {
                    value: 'id,asc',
                    squash: true
                },
                search: null
            },
            resolve: {
                pagingParams: ['$stateParams', 'PaginationUtil', function ($stateParams, PaginationUtil) {
                    return {
                        page: PaginationUtil.parsePage($stateParams.page),
                        sort: $stateParams.sort,
                        predicate: PaginationUtil.parsePredicate($stateParams.sort),
                        ascending: PaginationUtil.parseAscending($stateParams.sort),
                        search: $stateParams.search
                    };
                }]
            }
        })
        .state('profile-detail', {
            parent: 'profile',
            url: '/profile/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'Profile'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/profile/profile-detail.html',
                    controller: 'ProfileDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                entity: ['$stateParams', 'Profile', function($stateParams, Profile) {
                    return Profile.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'profile',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('profile-detail.edit', {
            parent: 'profile-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/profile/profile-dialog.html',
                    controller: 'ProfileDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Profile', function(Profile) {
                            return Profile.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('profile.new', {
            parent: 'profile',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/profile/profile-dialog.html',
                    controller: 'ProfileDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                credibility: null,
                                credits: null,
                                degree: null,
                                semester: null,
                                faculty: null,
                                university: null,
                                birthday: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('profile', null, { reload: 'profile' });
                }, function() {
                    $state.go('profile');
                });
            }]
        })
        .state('profile.edit', {
            parent: 'profile',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/profile/profile-dialog.html',
                    controller: 'ProfileDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Profile', function(Profile) {
                            return Profile.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('profile', null, { reload: 'profile' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('profile.delete', {
            parent: 'profile',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/profile/profile-delete-dialog.html',
                    controller: 'ProfileDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['Profile', function(Profile) {
                            return Profile.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('profile', null, { reload: 'profile' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
