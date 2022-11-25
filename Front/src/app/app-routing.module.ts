import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignInComponent } from './pages/sign-in/sign-in.component';
import { SignUpComponent } from './pages/sign-up/sign-up.component';
import { EditUserComponent } from './pages/edit-user/edit-user.component';
import { SaibaMaisComponent } from './pages/saiba-mais/saiba-mais.component';
import { HomeComponent } from './pages/home/home.component';
import { ContentComponent } from './pages/content/content.component';
import { InserirTurismoComponent} from './pages/inserir-turismo/inserir-turismo.component'
const routes: Routes = [
  { path: '', component: HomeComponent,
    children: [
      { path: 'home', component: ContentComponent },
      { path: 'saiba-mais', component: SaibaMaisComponent }
    ]
  },
  { path: '**', redirectTo: 'page-not-found' },
  { path: 'sign-in', component: SignInComponent },
  { path: 'sign-up', component: SignUpComponent },
  { path: 'edit-user', component: EditUserComponent },
  { path: 'inserir-turismo', component: InserirTurismoComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
