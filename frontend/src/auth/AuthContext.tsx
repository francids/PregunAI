import { createContext } from "react";
import type User from "./interfaces/User";
import type { AxiosError, AxiosResponse } from "axios";

interface AuthContextType {
  token: string | null;
  isAuthenticated: () => boolean;
  checkTokenValidity: () => boolean;
  login: (email: string, password: string) => Promise<unknown>;
  register: (
    email: string,
    password: string,
    fullName: string
  ) => Promise<AxiosResponse | AxiosError>;
  logout: () => void;
  loading: boolean;
  currentUser: User | null;
  fetchUserData: () => Promise<void>;
}

export const AuthContext = createContext<AuthContextType | null>(null);
