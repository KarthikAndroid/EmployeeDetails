
package com.find.employee.app.di.component;


import com.find.employee.app.di.module.AppModule;
import com.find.employee.app.di.module.NetModule;
import com.find.employee.app.di.scope.AppScope;
import com.find.employee.app.view.EmployeesViewModel;

import dagger.Component;

@Component(modules = {AppModule.class, NetModule.class})
@AppScope
public interface AppComponent {
    void inject(EmployeesViewModel employeesViewModel);
//
//    void inject(DataProvider dataProvider);


}
