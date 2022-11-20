import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SidebarComponent } from './pages/shared/sidebar/sidebar.component';
import { NavbarComponent } from './pages/shared/navbar/navbar.component';
import { SignInComponent } from './pages/sign-in/sign-in.component';
import { SignUpComponent } from './pages/sign-up/sign-up.component';
import { SaibaMaisComponent } from './pages/saiba-mais/saiba-mais.component';
import { EditUserComponent } from './pages/edit-user/edit-user.component';
import { ContentComponent } from './pages/content/content.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SidebarComponent,
    NavbarComponent,
    SignInComponent,
    SignUpComponent,
    SaibaMaisComponent,
    EditUserComponent,
    ContentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
