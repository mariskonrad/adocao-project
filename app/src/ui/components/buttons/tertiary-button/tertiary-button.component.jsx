import './tertiary-button.css'

export function TertiaryButton({ text, onClick }) {
  return (
    <>
      <button onClick={() => onClick()} className="tertiary-button">
        {text}
      </button>
    </>
  )
}
