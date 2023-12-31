import { BrowserRouter, Route, Routes } from 'react-router-dom';
import HomePage from './pages/HomePage';
import LoginPage from './pages/LoginPage';
import SignUpPage from './pages/SignUpPage';
import NoPage from './pages/NoPage';
import StorePage from './pages/StorePage';
import EquipmentDetailPage from './pages/EquipmentDetailPage';
import About from './pages/AboutUsPage';
import PaymentGateway from './pages/PaymentGateway';
import UserDashboard from './pages/UserDashboard';
import AdminDashboard from './pages/AdminDashboard';


function App() {
  return (
    <BrowserRouter>
    <Routes>
      <Route index element={<HomePage />} />
      <Route path="home" element={<HomePage />} />
      <Route path="login" element={<LoginPage />} />
      <Route path="signup" element={<SignUpPage />} />
      <Route path="equipment-store" element={<StorePage />} />
      <Route path="about" element={<About />} />
      <Route path="payment-page/:equipmentId" element={<PaymentGateway />} />
      <Route path="equipment-store/:equipmentId" element={<EquipmentDetailPage />} />
      <Route path="user-dashboard/:equipmentId" element={<UserDashboard />} />
      <Route path="admin-dashboard" element={<AdminDashboard />} />
      <Route path="*" element={<NoPage />} />
    </Routes>
  </BrowserRouter>
  );
}

export default App;
