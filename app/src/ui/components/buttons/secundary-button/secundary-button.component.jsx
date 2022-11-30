import './secundary-button.css'

export function SecundaryButton({ text, onClick, isTextBold, margin, width, colorText }) {
  return (
    <button
      onClick={() => onClick()}
      className="secundary-button"
      style={{ margin: margin, width: width, color: colorText ? colorText : '#323232' }}
    >
      {text}
    </button>
  )
}
