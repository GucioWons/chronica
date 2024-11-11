import axios, {AxiosError, AxiosResponse, InternalAxiosRequestConfig} from "axios";

export const setupAxiosInterceptor = (refreshUsersToken: (requestConfig: InternalAxiosRequestConfig) => Promise<void>) =>
{
    axios.interceptors.response.use(
        (response: AxiosResponse) => response,
        async (error: AxiosError) => {
            const originalRequest = error.config as InternalAxiosRequestConfig & { _retry?: boolean };
            if (error.response?.status === 401 && !originalRequest._retry) {
                originalRequest._retry = true;
                return refreshUsersToken(originalRequest)
                    .then(() => axios(originalRequest))
                    .catch((refreshError) => Promise.reject(refreshError));
            }
            return Promise.reject(error);
        }
    );
};