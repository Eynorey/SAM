(function () {
    'use strict';

    angular
        .module('samApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
            .state('course', {
                parent: 'entity',
                url: '/course?page&sort&search',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'SAM - Courses'
                },
                views: {
                    'content@': {
                        templateUrl: 'app/entities/course/courses.html',
                        controller: 'CourseController',
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
            .state('schedule', {
                parent: 'entity',
                url: '/schedule',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'SAM - Your Schedule'
                },
                views: {
                    'content@': {
                        templateUrl: 'app/entities/course/schedule.html',
                        controller: 'ScheduleController',
                        controllerAs: 'vm'
                    }
                }
            })
            .state('offerings', {
                parent: 'entity',
                url: '/offerings',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'SAM - Your Offered Courses'
                },
                views: {
                    'content@': {
                        templateUrl: 'app/entities/course/offerings.html',
                        controller: 'ScheduleController',
                        controllerAs: 'vm'
                    }
                }
            })
            .state('course-detail', {
                parent: 'course',
                url: '/course/{id}',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'Course'
                },
                views: {
                    'content@': {
                        templateUrl: 'app/entities/course/course-detail.html',
                        controller: 'CourseDetailController',
                        controllerAs: 'vm'
                    }
                },
                resolve: {
                    entity: ['$stateParams', 'Course', function ($stateParams, Course) {
                        return Course.get({id: $stateParams.id}).$promise;
                    }],
                    previousState: ["$state", function ($state) {
                        var currentStateData = {
                            name: $state.current.name || 'course',
                            params: $state.params,
                            url: $state.href($state.current.name, $state.params)
                        };
                        return currentStateData;
                    }]
                }
            })
            .state('course-detail.edit', {
                parent: 'course-detail',
                url: '/detail/edit',
                data: {
                    authorities: ['ROLE_USER']
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function ($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'app/entities/course/course-dialog.html',
                        controller: 'CourseDialogController',
                        controllerAs: 'vm',
                        backdrop: 'static',
                        size: 'lg',
                        resolve: {
                            entity: ['Course', function (Course) {
                                return Course.get({id: $stateParams.id}).$promise;
                            }]
                        }
                    }).result.then(function () {
                        $state.go('^', {}, {reload: false});
                    }, function () {
                        $state.go('^');
                    });
                }]
            })
            .state('course.new', {
                parent: 'course',
                url: '/new',
                data: {
                    authorities: ['ROLE_USER']
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function ($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'app/entities/course/course-dialog.html',
                        controller: 'CourseDialogController',
                        controllerAs: 'vm',
                        backdrop: 'static',
                        size: 'lg',
                        resolve: {
                            entity: function () {
                                return {
                                    title: null,
                                    description: null,
                                    start: null,
                                    end: null,
                                    location: null,
                                    maxAttendees: null,
                                    id: null
                                };
                            }
                        }
                    }).result.then(function () {
                        $state.go('course', null, {reload: 'course'});
                    }, function () {
                        $state.go('course');
                    });
                }]
            })
            .state('course.edit', {
                parent: 'course',
                url: '/{id}/edit',
                data: {
                    authorities: ['ROLE_USER']
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function ($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'app/entities/course/course-dialog.html',
                        controller: 'CourseDialogController',
                        controllerAs: 'vm',
                        backdrop: 'static',
                        size: 'lg',
                        resolve: {
                            entity: ['Course', function (Course) {
                                return Course.get({id: $stateParams.id}).$promise;
                            }]
                        }
                    }).result.then(function () {
                        $state.go('course', null, {reload: 'course'});
                    }, function () {
                        $state.go('^');
                    });
                }]
            })
            .state('course.delete', {
                parent: 'course',
                url: '/{id}/delete',
                data: {
                    authorities: ['ROLE_USER']
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function ($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'app/entities/course/course-delete-dialog.html',
                        controller: 'CourseDeleteController',
                        controllerAs: 'vm',
                        size: 'md',
                        resolve: {
                            entity: ['Course', function (Course) {
                                return Course.get({id: $stateParams.id}).$promise;
                            }]
                        }
                    }).result.then(function () {
                        $state.go('course', null, {reload: 'course'});
                    }, function () {
                        $state.go('^');
                    });
                }]
            });
    }

})();
