import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
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
import { SidebarComponent } from './components/onboard/sidebar/sidebar.component';
import { NgxUiLoaderHttpModule, NgxUiLoaderModule } from 'ngx-ui-loader';
import { FeedbackListComponent } from './components/feedback-list/feedback-list.component';
import { CreateFeedbackComponent } from './components/create-feedback/create-feedback.component';
import { UpdateFeedbackComponent } from './components/update-feedback/update-feedback.component';
import { EmpEvaluationComponent } from './components/emp-evaluation/emp-evaluation.component';
import { DatePipe } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    DashboardComponent,
    LogoutComponent,
    HomeComponent,
    RegisterComponent,
    SideNavigationComponent,
    AddEmployeeComponent,
    ViewEmployeeComponent,
    UpdateEmployeeComponent,
    OnboardComponent,
    SidebarComponent,
    FeedbackListComponent,
    CreateFeedbackComponent,
    UpdateFeedbackComponent,
    EmpEvaluationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgxUiLoaderModule,
    NgxUiLoaderHttpModule.forRoot({ showForeground: true }),
    DatePipe
  ],
  providers: [
    AuthActivateRouteGuard,
    DatePipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule {

}
