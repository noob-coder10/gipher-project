import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { GifsComponent } from './gifs/gifs.component';
import { MatCardModule } from '@angular/material/card';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatChipsModule } from '@angular/material/chips';
import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatMenuModule } from '@angular/material/menu';
import { SignupComponent } from './pages/signup/signup.component';
import { LoginComponent } from './pages/login/login.component';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule } from '@angular/forms';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { authInceptorProviders } from './services/auth.interceptor';
import { ProfileComponent } from './pages/profile/profile.component';
import { HomeComponent } from './pages/home/home.component';
import { ChangePasswordComponent } from './pages/change-password/change-password.component';
import { FavouritesComponent } from './pages/favourites/favourites.component';
import { FooterComponent } from './footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    GifsComponent,
    SignupComponent,
    LoginComponent,
    ProfileComponent,
    HomeComponent,
    ChangePasswordComponent,
    FavouritesComponent,
    FooterComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatCardModule,
    BrowserAnimationsModule,
    MatChipsModule,
    MatIconModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatMenuModule,
    MatInputModule,
    MatButtonModule,
    FormsModule,
    HttpClientModule,
    MatSnackBarModule,
  ],
  providers: [authInceptorProviders],
  bootstrap: [AppComponent],
})
export class AppModule {}
