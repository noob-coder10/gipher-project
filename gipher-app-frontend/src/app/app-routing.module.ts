import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GifsComponent } from './gifs/gifs.component';
import { ChangePasswordComponent } from './pages/change-password/change-password.component';
import { FavouritesComponent } from './pages/favourites/favourites.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { SignupComponent } from './pages/signup/signup.component';
import { HomeGuard } from './services/home.guard';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    pathMatch: 'full',
  },
  {
    path: 'gif',
    component: GifsComponent,
    pathMatch: 'full',
    canActivate: [HomeGuard],
  },
  {
    path: 'favourites',
    component: FavouritesComponent,
    pathMatch: 'full',
    canActivate: [HomeGuard],
  },
  {
    path: 'profile',
    component: ProfileComponent,
    pathMatch: 'full',
    canActivate: [HomeGuard],
  },
  {
    path: 'changePassword',
    component: ChangePasswordComponent,
    pathMatch: 'full',
    canActivate: [HomeGuard],
  },
  {
    path: 'signup',
    component: SignupComponent,
    pathMatch: 'full',
  },

  {
    path: 'login',
    component: LoginComponent,
    pathMatch: 'full',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
