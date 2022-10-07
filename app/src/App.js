import { Routes, Route, Navigate } from 'react-router-dom'
import { useGlobalUser } from './assets/context'
import { ROUTES } from './constants/routes'
import './App.css'
import {
  HomeScreen,
  LoginScreen,
  SignUpScreen,
  AnimalsScreen,
  AnimalScreen,
  ContactScreen,
  HelpScreen
} from './ui/screens'

function PrivateRoute({ children }) {
  const [user] = useGlobalUser()
  if (user.email) {
    return <>{children}</>
  }
  return <Navigate to={ROUTES.LOGIN} />
}

function App() {
  return (
    <div>
      <Routes>
        <Route path={ROUTES.LOGIN} element={<LoginScreen />} />
        <Route path={ROUTES.SIGN_UP} element={<SignUpScreen />} />
        <Route
          path={ROUTES.HOME}
          element={
            <PrivateRoute>
              <HomeScreen />
            </PrivateRoute>
          }
        />
        <Route
          path={ROUTES.ANIMALS}
          element={
            <PrivateRoute>
              <AnimalsScreen />
            </PrivateRoute>
          }
        />
        <Route
          path={`${ROUTES.ANIMALS}/:id`}
          element={
            <PrivateRoute>
              <AnimalScreen />
            </PrivateRoute>
          }
        />
        <Route
          path={ROUTES.CONTACT}
          element={
            <PrivateRoute>
              <ContactScreen />
            </PrivateRoute>
          }
        />
        <Route
          path={ROUTES.HELP}
          element={
            <PrivateRoute>
              <HelpScreen />
            </PrivateRoute>
          }
        />
      </Routes>
    </div>
  )
}

export default App
