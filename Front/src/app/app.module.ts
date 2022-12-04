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
import { FormsModule } from '@angular/forms';
import { InserirTurismoComponent } from './pages/inserir-turismo/inserir-turismo.component';
import { HttpClientModule } from '@angular/common/http';

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
    ContentComponent,
    InserirTurismoComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
