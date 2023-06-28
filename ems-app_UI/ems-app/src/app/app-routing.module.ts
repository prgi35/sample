import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { LogoutComponent } from './components/logout/logout.component';
import { AuthActivateRouteGuard } from './routeguards/auth.routeguard';
import { HomeComponent } from './components/home/home.component';
import { RegisterComponent } from './components/register/register.component';
import { SideNavigationComponent } from './components/side-navigation/side-navigation.component';
import { AddEmployeeComponent } from './components/onboard/add-employee/add-employee.component';
import { ViewEmployeeComponent } from './components/onboard/view-employee/view-employee.component';
import { UpdateEmployeeComponent } from './components/onboard/update-employee/update-employee.component';
import { OnboardComponent } from './components/onboard/onboard/onboard.component';
import { FeedbackListComponent } from './components/feedback-list/feedback-list.component';
import { CreateFeedbackComponent } from './components/create-feedback/create-feedback.component';
import { UpdateFeedbackComponent } from './components/update-feedback/update-feedback.component';
import { EmpEvaluationComponent } from './components/emp-evaluation/emp-evaluation.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full'},
  { path: 'home', component: HomeComponent},
  { path: 'login', component: LoginComponent},
  { path: 'dashboard', component: DashboardComponent, canActivate: [AuthActivateRouteGuard]},
  { path: 'logout', component: LogoutComponent},
  { path: 'register', component:RegisterComponent},
  {path:'feedbackList', component:FeedbackListComponent, canActivate: [AuthActivateRouteGuard]},
  {path:'createFeedback' , component:CreateFeedbackComponent, canActivate: [AuthActivateRouteGuard]},
  {path:'updateFeedback/:id', component:UpdateFeedbackComponent, canActivate: [AuthActivateRouteGuard]},
  {path:'empevaluation',component:EmpEvaluationComponent, canActivate: [AuthActivateRouteGuard]},
  { path: 'sidenav', component: SideNavigationComponent, canActivate: [AuthActivateRouteGuard]},
  { path: 'onboard', component: OnboardComponent,
    children: [
      { path: 'add', component: AddEmployeeComponent,canActivate: [AuthActivateRouteGuard] },
      { path: 'view', component: ViewEmployeeComponent, canActivate: [AuthActivateRouteGuard] },
      { path: 'update/:employeeId', component: UpdateEmployeeComponent, canActivate: [AuthActivateRouteGuard] }
    ]
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
